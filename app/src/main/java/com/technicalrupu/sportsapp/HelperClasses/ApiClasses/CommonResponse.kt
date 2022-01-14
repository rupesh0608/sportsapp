package com.technicalrupu.sportsapp.HelperClasses.ApiClasses

class CommonResponse(var status:Boolean,var message:String) {

   @JvmName("getStatus1")
   fun getStatus():Boolean{
       return status
   }
    @JvmName("getMessage1")
    fun getMessage():String{
        return message
    }
}