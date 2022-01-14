package com.technicalrupu.sportsapp.HomeFragment

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.sportsapp.HomeFragment.Adapter.ChatListAdapter
import com.technicalrupu.sportsapp.HomeFragment.classes.Chats
import com.technicalrupu.sportsapp.R

class ChatListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_list)

        val btnBack=findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
        val data = ArrayList<Chats>()

        data.add(Chats(
            "10:00 PM",
            "Hey  Welcome to the Feature community! If you ever have a question or need help, feel free to message me! ",
            "MSG")
        )
        data.add(Chats(
            "10:00 PM",
            "What does \nSplit Participants\n mean in a double elimination bracket?",
            "REPLY")
        )
        data.add(Chats(
            "10:00 PM",
            "Split Participants allows organizers to host single stage (and two stage tournaments) with participants starting in the losers bracket (aka \nlower bracket\n).\n",
            "MSG")
        )

        val adapter = ChatListAdapter(data)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
    }
}