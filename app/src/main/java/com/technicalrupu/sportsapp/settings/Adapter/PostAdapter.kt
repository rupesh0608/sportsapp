package com.technicalrupu.sportsapp.settings.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.sportsapp.R


class PostAdapter(val list: ArrayList<Int>) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_gallery, parent, false)
        return ViewHolder(view,list)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = list[position]

//              val imgFile = File(list.get(position))
//              Picasso.get().load(Uri.fromFile(imgFile)).into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View, list: ArrayList<Int>) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val card: LinearLayout = itemView.findViewById(R.id.card)
        init {
            itemView.setOnClickListener {
//               val mainImageView= ref.findViewById<ImageView>(R.id.mainImageView)
//                val imgFile = File(list[adapterPosition])
//                val myBitmap = BitmapFactory.decodeFile(imgFile.absolutePath)
//                mainImageView.setImageBitmap(myBitmap)
//                mainImageView.setDrawingCacheEnabled(true)
            }
        }

    }
}
