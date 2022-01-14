package com.technicalrupu.sportsapp.MainActivityFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.technicalrupu.sportsapp.HomeFragment.ChatFragment
import com.technicalrupu.sportsapp.HomeFragment.FeedFragment
import com.technicalrupu.sportsapp.HomeFragment.NotificationFragment
import com.technicalrupu.sportsapp.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val btnFeed = view.findViewById<ImageView>(R.id.btnFeed)
        changeButtonIcon(view,R.id.btnFeed, R.drawable.ic_feed_blue)
        change(R.id.fragmentContainer1, FeedFragment())

        btnFeed.setOnClickListener {
            changeButtonIcon(view,R.id.btnFeed, R.drawable.ic_feed_blue)
            change(R.id.fragmentContainer1, FeedFragment())
        }
        val btnNewPost = view.findViewById<ImageView>(R.id.btnNewPost)
        btnNewPost.setOnClickListener {
            startActivity(Intent(view.context, NewPostActivity::class.java))
        }
        val btnChat = view.findViewById<ImageView>(R.id.btnChat)
        btnChat.setOnClickListener {
            changeButtonIcon(view,R.id.btnChat, R.drawable.ic_chat_blue)
            change(R.id.fragmentContainer1, ChatFragment())
        }
        val btnNotification = view.findViewById<ImageView>(R.id.btnNotification)
        btnNotification.setOnClickListener {
            changeButtonIcon(view,R.id.btnNotification, R.drawable.ic_bell_blue)
            change(R.id.fragmentContainer1, NotificationFragment())
        }
        return view
    }

    private fun change(containerId: Int, fragment: Fragment) {
        childFragmentManager.beginTransaction().replace(containerId, fragment).commit()
    }

    private fun changeButtonIcon(view:View,ImageViewId: Int, iconId: Int) {
        val btn = view.findViewById<ImageView>(ImageViewId)
        setDefaultIcon(view)
        when (ImageViewId) {
            R.id.btnFeed -> btn.setImageDrawable(ContextCompat.getDrawable(view.context, iconId))
            R.id.btnNewPost -> btn.setImageDrawable(ContextCompat.getDrawable(view.context, iconId))
            R.id.btnChat -> btn.setImageDrawable(ContextCompat.getDrawable(view.context, iconId))
            R.id.btnNotification -> btn.setImageDrawable(ContextCompat.getDrawable(view.context, iconId))
        }
    }
    private fun setDefaultIcon(view:View) {
        val btnFeed=view.findViewById<ImageView>(R.id.btnFeed)
        btnFeed.setImageDrawable(ContextCompat.getDrawable(view.context,R.drawable.ic_feed_grey))
        val btnNewPost=view.findViewById<ImageView>(R.id.btnNewPost)
        btnNewPost.setImageDrawable(ContextCompat.getDrawable(view.context,R.drawable.ic_add_grey))
        val btnChat=view.findViewById<ImageView>(R.id.btnChat)
        btnChat.setImageDrawable(ContextCompat.getDrawable(view.context,R.drawable.ic_chat_grey))
        val btnNotification=view.findViewById<ImageView>(R.id.btnNotification)
        btnNotification.setImageDrawable(ContextCompat.getDrawable(view.context,R.drawable.ic_bell_grey))
    }
}