package com.technicalrupu.sportsapp.MainActivityFragments.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.technicalrupu.sportsapp.MainActivityFragments.Fragment.DateFragment
import com.technicalrupu.sportsapp.MainActivityFragments.Fragment.InnerLeaderboardFragment

class LeaderBoardAdapter( var context: Context,
fm: FragmentManager,
var totalTabs: Int
) :
FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            position-> InnerLeaderboardFragment()
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}