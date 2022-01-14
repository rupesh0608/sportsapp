package com.technicalrupu.sportsapp.HomeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technicalrupu.sportsapp.HelperClasses.ApiClasses.Feed
import com.technicalrupu.sportsapp.HelperClasses.ApiClasses.ProfileData
import com.technicalrupu.sportsapp.HelperClasses.ApiClasses.UserFeed
import com.technicalrupu.sportsapp.HelperClasses.Retrofit
import com.technicalrupu.sportsapp.HelperClasses.SharedPreferences
import com.technicalrupu.sportsapp.HomeFragment.Adapter.FeedAdapter
import com.technicalrupu.sportsapp.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_feed, container, false)
        getFeedList(view)
        return view
    }

    private fun getFeedList(view:View){
        val retrofit = Retrofit()
        val sf=SharedPreferences(this.requireActivity())
        val profileData: ProfileData = sf.getProfileData()!!
        val id=profileData.getId()
            retrofit.create().viewUserFeed(id)
                .enqueue(object : Callback<UserFeed> {
                    override fun onResponse(call: Call<UserFeed>, response: Response<UserFeed>) {
                        val data = response.body()
                        if (data != null) {
                            if (data.getStatus()) {
                                createFeedsView(view,data.getData())
                            } else {
                                Toast.makeText(view.context, data.getMessage(), Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }
                    override fun onFailure(call: Call<UserFeed>, t: Throwable) {
                        Toast.makeText(view.context, t.message, Toast.LENGTH_SHORT)
                            .show()
                    }

                })
    }

    fun createFeedsView(view: View, data: Array<Feed>)
    {
        val adapter = FeedAdapter(data)
        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(view.context)
        recyclerview.adapter = adapter
    }
}