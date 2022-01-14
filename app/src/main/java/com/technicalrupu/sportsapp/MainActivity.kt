package com.technicalrupu.sportsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.technicalrupu.sportsapp.BuySellFragment.BuySellFragment
import com.technicalrupu.sportsapp.HelperClasses.Fragment
import com.technicalrupu.sportsapp.MainActivityFragments.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = Fragment(this)
        val btnHome = findViewById<ImageView>(R.id.btnHome)
        changeButtonIcon(R.id.btnHome, R.drawable.ic_home_blue)
        fragment.change(R.id.fragmentContainer, HomeFragment())

        btnHome.setOnClickListener {
            changeButtonIcon(R.id.btnHome, R.drawable.ic_home_blue)
            fragment.change(R.id.fragmentContainer, HomeFragment())
        }
        val btnCasino = findViewById<ImageView>(R.id.btnCasino)
        btnCasino.setOnClickListener {
            changeButtonIcon(R.id.btnCasino, R.drawable.ic_casino_blue)
            fragment.change(R.id.fragmentContainer, CasinoFragment())
        }
        val btnBuySell = findViewById<ImageView>(R.id.btnBuySell)
        btnBuySell.setOnClickListener {
            changeButtonIcon(R.id.btnBuySell, R.drawable.ic_buy_sell_blue)
            fragment.change(R.id.fragmentContainer, BuySellFragment())
        }
        val btnLeaderBoard= findViewById<ImageView>(R.id.btnLeaderBoard)
        btnLeaderBoard.setOnClickListener {
            changeButtonIcon(R.id.btnLeaderBoard, R.drawable.ic_leaderboard_blue)
            fragment.change(R.id.fragmentContainer, LeaderBoardFragment())
        }
        val btnSetting = findViewById<ImageView>(R.id.btnSetting)
        btnSetting.setOnClickListener {
            changeButtonIcon(R.id.btnSetting, R.drawable.ic_setting_blue)
            fragment.change(R.id.fragmentContainer, SettingFragment())
        }
    }

    private fun changeButtonIcon(ImageViewId: Int, iconId: Int) {
         val btn=findViewById<ImageView>(ImageViewId)
        setDefaultIcon()
        when (ImageViewId) {
            R.id.btnHome ->btn.setImageDrawable(ContextCompat.getDrawable(this,iconId))
            R.id.btnCasino ->btn.setImageDrawable(ContextCompat.getDrawable(this,iconId))
            R.id.btnBuySell ->btn.setImageDrawable(ContextCompat.getDrawable(this,iconId))
            R.id.btnLeaderBoard ->btn.setImageDrawable(ContextCompat.getDrawable(this,iconId))
            R.id.btnSetting ->btn.setImageDrawable(ContextCompat.getDrawable(this,iconId))
        }
    }
    private fun setDefaultIcon() {
        val btnHome=findViewById<ImageView>(R.id.btnHome)
        btnHome.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_home_grey))
        val btnCasino=findViewById<ImageView>(R.id.btnCasino)
        btnCasino.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_casino))
        val btnBuySell=findViewById<ImageView>(R.id.btnBuySell)
        btnBuySell.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_buy_sell_grey))
        val btnLeaderBoard=findViewById<ImageView>(R.id.btnLeaderBoard)
        btnLeaderBoard.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_leaderboard_grey))
        val btnSetting=findViewById<ImageView>(R.id.btnSetting)
        btnSetting.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_setting_grey))
    }

}