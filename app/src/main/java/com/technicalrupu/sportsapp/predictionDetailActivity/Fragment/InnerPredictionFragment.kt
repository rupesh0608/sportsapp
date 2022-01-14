package com.technicalrupu.sportsapp.predictionDetailActivity.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.sportsapp.HomeFragment.Adapter.ChatAdapter
import com.technicalrupu.sportsapp.R
import com.technicalrupu.sportsapp.predictionDetailActivity.Adapter.PredictionListAdapter

class InnerPredictionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_inner_prediction, container, false)
        val data = ArrayList<Int>()

        for (i in 1..30) {
            data.add(i)
        }
        val adapter = PredictionListAdapter(data)
        val recyclerview=view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(view.context)
        recyclerview.adapter = adapter
        return  view
    }

}