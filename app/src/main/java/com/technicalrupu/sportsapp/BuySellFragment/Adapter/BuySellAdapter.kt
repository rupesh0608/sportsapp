package com.technicalrupu.sportsapp.BuySellFragment.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.sportsapp.HomeFragment.ChatListActivity
import com.technicalrupu.sportsapp.R

class BuySellAdapter(val list: ArrayList<Int>, val s: String) :
    RecyclerView.Adapter<BuySellAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_buy, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = list[position]
        holder.btnType.text = s
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {


        val btnType = ItemView.findViewById<TextView>(R.id.btnType)

        init {
            itemView.setOnClickListener {
                itemView.context.startActivity(
                    Intent(
                        itemView.context,
                        ChatListActivity::class.java
                    )
                )
            }
        }

    }
}
