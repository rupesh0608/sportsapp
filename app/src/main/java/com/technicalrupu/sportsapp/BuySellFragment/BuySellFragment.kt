package com.technicalrupu.sportsapp.BuySellFragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.technicalrupu.sportsapp.MainActivityFragments.Adapter.TabAdapter
import com.technicalrupu.sportsapp.R

class BuySellFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view= inflater.inflate(R.layout.fragment_buy_sell, container, false)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        val   viewPager = view.findViewById<ViewPager>(R.id.viewPager)

        tabLayout.addTab(tabLayout.newTab().setText("Basketball"))
        tabLayout.addTab(tabLayout.newTab().setText("Football"))
        tabLayout.addTab(tabLayout.newTab().setText("Cricket"))
        tabLayout.addTab(tabLayout.newTab().setText("Following"))

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#5F88FB"));
//        tabLayout.setSelectedTabIndicatorHeight( (5 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"))
        val adapter = TabAdapter(view.context, childFragmentManager,
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