package com.technicalrupu.sportsapp.HelperClasses.ApiClasses

class UserFeed(var status:Boolean,var message:String,var data:Array<Feed>) {

    @JvmName("getStatus1")
    fun getStatus(): Boolean {
        return status
    }

    @JvmName("getData1")
    fun getData():Array<Feed>{
        return data
    }

    @JvmName("getMessage1")
    fun getMessage():String{
        return message
    }
}