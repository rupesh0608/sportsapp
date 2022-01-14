package com.technicalrupu.sportsapp.HelperClasses

import android.app.Activity
import android.content.Context
import com.google.gson.Gson
import com.technicalrupu.sportsapp.HelperClasses.ApiClasses.ProfileData
import com.technicalrupu.sportsapp.HelperClasses.ApiClasses.UserLogin
import retrofit2.Callback

class SharedPreferences( var ref:Activity) {

     fun saveData(data: ProfileData) {
        val sharedPref = ref.getSharedPreferences(
            "LOGIN_DATA", Context.MODE_PRIVATE
        )
        val editor = sharedPref.edit()
        val gson = Gson()
        val json: String? = gson.toJson(data)
        editor.putString("data", json)
        editor.putString("loginStatus", true.toString())
            .apply()
    }

    fun getLoginStatus(): String? {
        val sharedPref = ref.getSharedPreferences(
            "LOGIN_DATA", Context.MODE_PRIVATE
        )
       return sharedPref.getString("loginStatus", "")
    }
    fun getProfileData(): ProfileData? {
        val sharedPref = ref.getSharedPreferences(
            "LOGIN_DATA", Context.MODE_PRIVATE
        )
        val gson = Gson()
        val json: String? = sharedPref.getString("data", "")
        return gson.fromJson(json, ProfileData::class.java)
    }
}