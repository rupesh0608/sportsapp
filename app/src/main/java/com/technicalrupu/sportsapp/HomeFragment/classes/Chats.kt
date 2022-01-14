package com.technicalrupu.sportsapp.HomeFragment.classes

class Chats(var time :String,var msg:String,var type:String) {


   @JvmName("getTime1")
   fun getTime():String{
       return  time
   }

    fun getMessage():String{
       return  msg
    }

    @JvmName("getType1")
    fun getType():String{
        return type
    }

}