package com.technicalrupu.sportsapp.HomeFragment.Adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.sportsapp.HomeFragment.ChatListActivity
import com.technicalrupu.sportsapp.R

class ChatAdapter(val list: ArrayList<Int>):RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = list[position]
//        holder.imageView.drawable
    }
    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        init {
            itemView.setOnClickListener{
                itemView.context.startActivity(Intent(itemView.context,ChatListActivity::class.java))
            }
        }

    }
}
