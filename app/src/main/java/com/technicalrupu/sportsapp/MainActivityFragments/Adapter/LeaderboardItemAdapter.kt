package com.technicalrupu.sportsapp.MainActivityFragments.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.sportsapp.PredictionDetailsActivity
import com.technicalrupu.sportsapp.R

class LeaderboardItemAdapter(val list: ArrayList<Int>) :
    RecyclerView.Adapter<LeaderboardItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_leaderboard, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val layout: LinearLayout = ItemView.findViewById(R.id.layout)

        init {
            itemView.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context,PredictionDetailsActivity::class.java))
            }
        }

    }
}
