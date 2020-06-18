package com.example.taxyrider.mviarchitecture.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taxyrider.R
import com.example.taxyrider.mviarchitecture.data.model.User
import kotlinx.android.synthetic.main.item_layout.view.*

class ViewsAdapter(private val users: ArrayList<User>) : RecyclerView.Adapter<ViewsAdapter.ViewsHolder>() {

    class ViewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(user: User){
            itemView.textViewUserName.text = user.name
            itemView.textViewUserEmail.text = user.email
            Glide.with(itemView.imageViewAvatar.context)
                .load(user.avatar).into(itemView.imageViewAvatar)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewsHolder {
        return ViewsHolder( LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }


    override fun onBindViewHolder(holder: ViewsHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun addData(list: List<User>) {
        users.addAll(list)
        notifyDataSetChanged()
    }
}