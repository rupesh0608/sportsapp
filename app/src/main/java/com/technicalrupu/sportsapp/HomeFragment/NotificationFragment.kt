package com.technicalrupu.sportsapp.HomeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.sportsapp.HomeFragment.Adapter.NotificationAdapter
import com.technicalrupu.sportsapp.MainActivityFragments.Adapter.CasinoAdapter
import com.technicalrupu.sportsapp.R


class NotificationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val view= inflater.inflate(R.layout.fragment_notification, container, false)

        val data = ArrayList<Int>()

        for (i in 1..30) {
            data.add(i)
        }
        val adapter = NotificationAdapter(data)
        val recyclerview=view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(view.context)
        recyclerview.adapter = adapter
        return view
    }

}