package com.rajbagri.imagefirebase

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import com.rajbagri.imagefirebase.databinding.AddItemBinding

class addUserItem(context: Context,private var addDialogListener: AddDialogListener): AppCompatDialog(context){
    private lateinit var binding: AddItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.userButton.setOnClickListener{
            val task = binding.editTextTask.text.toString()
            val date = binding.editTextDate.text.toString()

            val item = useritem(0, task, date)
            addDialogListener.AddButtonClicked(item)
            dismiss()
        }



    }
}