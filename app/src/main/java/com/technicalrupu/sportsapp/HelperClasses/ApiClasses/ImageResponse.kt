package com.technicalrupu.sportsapp.HelperClasses.ApiClasses

class ImageResponse(var status:Boolean,var message:String,var data:Int) {

    @JvmName("getStatus1")
    fun getStatus():Boolean{
        return status
    }

    @JvmName("getMessage1")
    fun getMessage():String{
        return message
    }
}