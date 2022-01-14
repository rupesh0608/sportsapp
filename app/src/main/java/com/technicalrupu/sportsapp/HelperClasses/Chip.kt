package com.technicalrupu.sportsapp.HelperClasses

import android.app.Activity
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Toast
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.technicalrupu.sportsapp.R

class Chip(var ref: Activity) {

     fun addRemovableChip(label: String, hashtagList: ArrayList<String>){
         hashtagList.add(label)
        val chipGroup=ref.findViewById<ChipGroup>(R.id.chipGroup)

        val onCloseIconClickListener = View.OnClickListener {
            val anim = AlphaAnimation(1f,0f)
            anim.duration = 250
            anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(animation: Animation?) {}
                override fun onAnimationEnd(animation: Animation?) {
                    chipGroup.removeView(it)
                    hashtagList.remove((it as Chip).text.toString())
                }
                override fun onAnimationStart(animation: Animation?) {

                }
            })
            it.startAnimation(anim)
        }

        val newChip = Chip(ref, null, R.attr.chipStyle)
        newChip.text = label
        newChip.isClickable = true
        newChip.isFocusable = true
        newChip.setCloseIconResource(R.drawable.ic_cross_black)
        newChip.isCloseIconVisible=true
        newChip.setOnCloseIconClickListener(onCloseIconClickListener)
        chipGroup.addView(newChip)
    }

}