package com.technicalrupu.sportsapp.MainActivityFragments.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.sportsapp.R

class CasinoAdapter(val list: ArrayList<Int>):RecyclerView.Adapter<CasinoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_casino, parent, false)

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
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val card: LinearLayout = itemView.findViewById(R.id.card)

        init {
            itemView.setOnClickListener{
                Toast.makeText(ItemView.context, "item "+(adapterPosition+1),Toast.LENGTH_SHORT).show()
            }
        }

    }
}
