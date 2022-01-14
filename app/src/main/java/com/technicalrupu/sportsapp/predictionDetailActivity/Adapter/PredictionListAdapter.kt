package com.technicalrupu.sportsapp.predictionDetailActivity.Adapter

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

class PredictionListAdapter(val list: ArrayList<Int>):RecyclerView.Adapter<PredictionListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_buy, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = list[position]
        if(position%2==0)
        {
            holder.btnType.text="BUY"
        }else{
            holder.btnType.text="SELL"
        }

    }
    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val btnType = ItemView.findViewById<TextView>(R.id.btnType)
        init {
            itemView.setOnClickListener{
                itemView.context.startActivity(Intent(itemView.context,ChatListActivity::class.java))
            }
        }

    }
}
