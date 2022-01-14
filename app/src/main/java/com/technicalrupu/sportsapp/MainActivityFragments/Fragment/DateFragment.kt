package com.technicalrupu.sportsapp.MainActivityFragments.Fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.technicalrupu.sportsapp.MainActivityFragments.Adapter.DateFragmentAdapter
import com.technicalrupu.sportsapp.MainActivityFragments.Adapter.TabAdapter
import com.technicalrupu.sportsapp.R

class DateFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_date, container, false)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        val   viewPager = view.findViewById<ViewPager>(R.id.viewPager)

        tabLayout.addTab(tabLayout.newTab().setText("TUE \nFEB 9"))
        tabLayout.addTab(tabLayout.newTab().setText("WED \nFEB 10"))
        tabLayout.addTab(tabLayout.newTab().setText("THU \nFEB 11"))
        tabLayout.addTab(tabLayout.newTab().setText("FRI \nFEB 12"))
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = DateFragmentAdapter(view.context, childFragmentManager,
            tabLayout.tabCount)


        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        return view
    }
}