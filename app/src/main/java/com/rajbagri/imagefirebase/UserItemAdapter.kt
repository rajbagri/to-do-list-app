package com.rajbagri.imagefirebase

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserItemAdapter(
    var items: List<useritem>,
    private val viewModel: UserViewModel
): RecyclerView.Adapter<UserItemAdapter.userViewHolder>() {
    inner class userViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return userViewHolder(view)
    }

    override fun onBindViewHolder(holder: userViewHolder, position: Int) {
        val curUserItem = items[position]

        holder.itemView.findViewById<TextView>(R.id.user_task).text = curUserItem.task

        holder.itemView.findViewById<TextView>(R.id.date_set).text = curUserItem.time

        holder.itemView.findViewById<CheckBox>(R.id.check_box_delete_task).setOnClickListener{
            viewModel.delete(curUserItem)
        }

    }


    override fun getItemCount(): Int {
        return items.size
    }

}


