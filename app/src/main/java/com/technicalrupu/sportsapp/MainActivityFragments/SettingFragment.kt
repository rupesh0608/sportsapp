package com.technicalrupu.sportsapp.MainActivityFragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.technicalrupu.sportsapp.LoginActivity
import com.technicalrupu.sportsapp.R
import com.technicalrupu.sportsapp.settings.AboutUsActivity
import com.technicalrupu.sportsapp.settings.ChangePasswordActivity
import com.technicalrupu.sportsapp.settings.MyProfileActivity
import com.technicalrupu.sportsapp.settings.PrivacyPolicyActivity


class SettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container, false)

        val btnProfile = view.findViewById<LinearLayout>(R.id.btnProfile)
        btnProfile.setOnClickListener {
            startActivity(Intent(view.context, MyProfileActivity::class.java))
        }
        val btnChangePassword = view.findViewById<LinearLayout>(R.id.btnChangePassword)
        btnChangePassword.setOnClickListener {
            startActivity(Intent(view.context, ChangePasswordActivity::class.java))
        }
        val btnAboutUs = view.findViewById<LinearLayout>(R.id.btnAboutUs)
        btnAboutUs.setOnClickListener {
            startActivity(Intent(view.context, AboutUsActivity::class.java))
        }
        val btnPrivacyPolicy = view.findViewById<LinearLayout>(R.id.btnPrivacyPolicy)
        btnPrivacyPolicy.setOnClickListener {
            startActivity(Intent(view.context, PrivacyPolicyActivity::class.java))
        }
        val btnLogout = view.findViewById<LinearLayout>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            clearSharedPreferences(view)
        }
        return view
    }

    @SuppressLint("CommitPrefEdits")
    private fun clearSharedPreferences(view: View) {
        val preferences: SharedPreferences =
            view.context.getSharedPreferences("LOGIN_DATA", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.clear().apply()
        startActivity(Intent(view.context, LoginActivity::class.java))
        activity?.finish()
    }

}