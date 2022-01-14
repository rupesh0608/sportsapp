package com.technicalrupu.sportsapp.HomeFragment.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.with
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.technicalrupu.sportsapp.CommentsActivity
import com.technicalrupu.sportsapp.HelperClasses.ApiClasses.Feed
import com.technicalrupu.sportsapp.HelperClasses.ApiClasses.ImageFeed
import com.technicalrupu.sportsapp.HelperClasses.GlideApp
import com.technicalrupu.sportsapp.PostDetailActivity
import com.technicalrupu.sportsapp.ProfileForOtherUserActivity
import com.technicalrupu.sportsapp.R

class FeedAdapter( var list: Array<Feed>) :RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_feed, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = list[position]
        holder.txtTime.text = list[position].time
        holder.txtLike.text=list[position].feed_like
        holder.txtComment.text=list[position].feed_comments
        holder.txtReaction.text=list[position].feed_recreation
        var hashtag=""
        for(item in list[position].hashtag){
            hashtag=hashtag+item.hashtag+"\t"
        }
           val imageList:Array<ImageFeed> =list[position].images
        if(imageList.isNotEmpty()){
            Picasso.get().load(imageList[0].getImage()).into(holder.mainImage)
        }
        holder.txtHashtag.text=hashtag
        holder.txtDescription.text=list[position].description
    }
    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
     val txtTime: TextView =ItemView.findViewById<TextView>(R.id.txtTime)
     val txtLike: TextView =ItemView.findViewById<TextView>(R.id.txtLike)
     val txtComment: TextView =ItemView.findViewById<TextView>(R.id.txtComment)
     val txtReaction: TextView =ItemView.findViewById<TextView>(R.id.txtReaction)
     val txtHashtag: TextView =ItemView.findViewById<TextView>(R.id.txtHashtag)
     val txtDescription: TextView =ItemView.findViewById<TextView>(R.id.txtDescription)
        val topNameLayout:LinearLayout=ItemView.findViewById(R.id.topNameLayout)
        val mainImage: ImageView =ItemView.findViewById<ImageView>(R.id.mainImage)
        val profilePic:ImageView=ItemView.findViewById(R.id.profilePic)
        val btnComment:LinearLayout=ItemView.findViewById(R.id.btnComment)
        init {
            itemView.setOnClickListener{
                itemView.context.startActivity(Intent(itemView.context,PostDetailActivity::class.java))
            }
            topNameLayout.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context,ProfileForOtherUserActivity::class.java))
            }
            profilePic.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context,ProfileForOtherUserActivity::class.java))
            }
            btnComment.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context,CommentsActivity::class.java))
            }

        }

    }
}
