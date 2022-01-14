package com.technicalrupu.sportsapp.settings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.sportsapp.EditProfileActivity
import com.technicalrupu.sportsapp.R
import com.technicalrupu.sportsapp.settings.Adapter.PostAdapter

class MyProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        val btnBack=findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
        val btnEditProfile=findViewById<Button>(R.id.btnEditProfile)
        btnEditProfile.setOnClickListener {
            startActivity(Intent(this,EditProfileActivity::class.java))
        }
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