
package com.technicalrupu.sportsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.sportsapp.HomeFragment.ChatListActivity
import com.technicalrupu.sportsapp.settings.Adapter.PostAdapter

class ProfileForOtherUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_for_other_user)

        val btnBack=findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
        val btnFollowUnFollow=findViewById<Button>(R.id.btnFollowUnFollow)
        btnFollowUnFollow.setOnClickListener {
            if(btnFollowUnFollow.text=="Follow")
            {
                btnFollowUnFollow.text="Unfollow"
                val txtPleaseFollow=findViewById<TextView>(R.id.txtPleaseFollow)
                txtPleaseFollow.visibility= View.GONE
                val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
                recyclerview.visibility=View.VISIBLE
                requestPostGallery()

            }else{
                btnFollowUnFollow.text="Follow"
                val txtPleaseFollow=findViewById<TextView>(R.id.txtPleaseFollow)
                txtPleaseFollow.visibility= View.VISIBLE
                val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
                recyclerview.visibility=View.GONE
            }

        }
        val btnMessage=findViewById<Button>(R.id.btnMessage)
        btnMessage.setOnClickListener {
            startActivity(Intent(this,ChatListActivity::class.java))
        }


    }

    fun requestPostGallery(){
        val data = ArrayList<Int>()
        for (i in 1..20) {
            data.add(i)
        }
        val adapter= PostAdapter(data)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = GridLayoutManager(this, 3)
        recyclerview.adapter = adapter
    }
}