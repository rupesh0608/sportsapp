package com.technicalrupu.sportsapp.HelperClasses.ApiClasses

class UserLogin (var status:Boolean,var message:String,var data:ProfileData){
    @JvmName("getStatus1")
    fun getStatus(): Boolean {
        return status
    }

   @JvmName("getMessage1")
   fun getMessage(): String {
        return message
    }

    @JvmName("getData1")
    fun getData(): ProfileData {
        return data
    }
}