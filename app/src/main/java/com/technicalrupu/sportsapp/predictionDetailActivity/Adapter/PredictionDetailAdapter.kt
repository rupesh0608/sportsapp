package com.technicalrupu.sportsapp.predictionDetailActivity.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.technicalrupu.sportsapp.MainActivityFragments.Fragment.DateFragment
import com.technicalrupu.sportsapp.MainActivityFragments.Fragment.InnerLeaderboardFragment
import com.technicalrupu.sportsapp.predictionDetailActivity.Fragment.PredictionDateFragment

class PredictionDetailAdapter(var context: Context,
                              fm: FragmentManager,
                              var totalTabs: Int
) :
FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            position-> PredictionDateFragment()
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}