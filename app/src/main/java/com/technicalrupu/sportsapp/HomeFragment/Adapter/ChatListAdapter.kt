package com.technicalrupu.sportsapp.HomeFragment.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.sportsapp.HomeFragment.classes.Chats
import com.technicalrupu.sportsapp.R

class ChatListAdapter(val list: ArrayList<Chats>):RecyclerView.Adapter<ChatListAdapter.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        if(list[position].getType()=="MSG")
        {
            return 0
        }else{
            return  1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view1 = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chatlist_msg, parent, false)
        val view2 = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chatlist_reply, parent, false)

        return if(viewType==0) {
            ViewHolder(view1)
        }else{
            ViewHolder(view2)
        }

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

            }
        }

    }

    class ViewHolder2(ItemView: View): RecyclerView.ViewHolder(ItemView) {
        init {

        }
    }
}
