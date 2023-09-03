package com.rajbagri.imagefirebase

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajbagri.imagefirebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = UserViewModelFactory(repository = UserRepository(UserDatabase(this)))

        val viewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)

        val adapter = UserItemAdapter(listOf(), viewModel)
        binding.userItemRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.userItemRecyclerView.adapter = adapter




        viewModel.getItemInfo().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        binding.fab.setOnClickListener {
            addUserItem(this,
            object : AddDialogListener{
                override fun AddButtonClicked(item: useritem) {
                    viewModel.upsert(item)
                }
            }).show()
        }




    }
}
