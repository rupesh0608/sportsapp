package com.technicalrupu.sportsapp.predictionDetailActivity.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.technicalrupu.sportsapp.BuySellFragment.InnerBuySellFragment
import com.technicalrupu.sportsapp.predictionDetailActivity.Fragment.InnerPredictionFragment

class PredictionDateFragmentAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            position-> InnerPredictionFragment()
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}