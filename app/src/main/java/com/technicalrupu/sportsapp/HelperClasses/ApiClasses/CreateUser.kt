package com.technicalrupu.sportsapp.HelperClasses.ApiClasses

data class CreateUser ( var status:Boolean, var message:String, var data:CreateUserData){

    @JvmName("getStatus1")
    fun  getStatus(): Boolean {
         return status
     }


    @JvmName("getMessage1")
    fun getMessage(): String {
        return message
    }

    @JvmName("getData1")
    fun getData(): CreateUserData {
        return data
    }
}