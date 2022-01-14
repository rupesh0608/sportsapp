package com.technicalrupu.sportsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.sportsapp.Adapter.CommentAdapter
import com.technicalrupu.sportsapp.HomeFragment.Adapter.ChatAdapter

class CommentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        val btnBack=findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        val data = ArrayList<Int>()

        for (i in 1..30) {
            data.add(i)
        }
        val adapter = CommentAdapter(data)
        val recyclerview=findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
    }
}