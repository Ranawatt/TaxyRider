package com.example.taxyrider.mviarchitecture.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import androidx.recyclerview.widget.RecyclerView
import com.example.taxyrider.R
import com.example.taxyrider.mviarchitecture.data.model.User

class ViewsAdapter(private val arrayList: ArrayList<User>) : RecyclerView.Adapter<ViewsAdapter.ViewsHolder>() {

    class ViewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(user: User){
//            itemView.
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewsHolder {

        return LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent, false)
    }


    override fun onBindViewHolder(holder: ViewsHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return user.size
    }
}