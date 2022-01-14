package com.technicalrupu.sportsapp.BuySellFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.sportsapp.BuySellFragment.Adapter.BuySellAdapter
import com.technicalrupu.sportsapp.R

class InnerBuySellFragment : Fragment() {

    @SuppressLint("UseCompatLoadingForColorStateLists")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_inner_buy_sell, container, false)
        val btnBuy = view.findViewById<Button>(R.id.btnBuy)
        val btnSell = view.findViewById<Button>(R.id.btnSell)
        setRecyclerView(view,"BUY")
        btnBuy.setOnClickListener {
            btnBuy.backgroundTintList=resources.getColorStateList(R.color.blue_color_xml)
            btnSell.backgroundTintList=resources.getColorStateList(R.color.grey_color_xml)
            setRecyclerView(view,"BUY")
        }

        btnSell.setOnClickListener {
            btnBuy.backgroundTintList=resources.getColorStateList(R.color.grey_color_xml)
            btnSell.backgroundTintList=resources.getColorStateList(R.color.blue_color_xml)
            setRecyclerView(view,"SELL")
        }
        return view
    }
    private fun setRecyclerView(view:View, type:String){
        val data = ArrayList<Int>()

        for (i in 1..30) {
            data.add(i)
        }
        val adapter = BuySellAdapter(data,type)
        val recyclerview=view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(view.context)
        recyclerview.adapter = adapter
    }

}