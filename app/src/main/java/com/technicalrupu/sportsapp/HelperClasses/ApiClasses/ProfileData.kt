package com.technicalrupu.sportsapp.HelperClasses.ApiClasses

class ProfileData(
   var  id:Int,
    var profile_pic:String,
    var user_name:String,
    var first_name:String,
    var last_name:String,
    var bio: String,
    var email: String,
    var password:String,
    var mobile_no: String,
    var stripe_customer_id: Int,
    var authcode: String,
    var google_authentication_code:String,
    var device_token: String,
    var token:String,
    var last_login:String,
    var created_on: String,
    var active: String,
    var name: String,
    var notification: String,
    var prediction_percentage: String,
    var full_name:String
){
   @JvmName("getId1")
   fun getId(): Int {
    return id
   }
}