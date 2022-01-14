package com.technicalrupu.sportsapp.MainActivityFragments.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.sportsapp.MainActivityFragments.Adapter.CasinoAdapter
import com.technicalrupu.sportsapp.MainActivityFragments.Adapter.LeaderboardItemAdapter
import com.technicalrupu.sportsapp.R

class InnerLeaderboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View= inflater.inflate(R.layout.fragment_inner_leaderboard, container, false)
        val data = ArrayList<Int>()

        for (i in 1..20) {
            data.add(i)
        }
        val adapter = LeaderboardItemAdapter(data)
        val recyclerview=view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(view.context)
        recyclerview.adapter = adapter
        return view
    }

}