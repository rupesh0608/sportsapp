package com.technicalrupu.sportsapp.HelperClasses.ApiClasses

class ImageFeed(var id :String,var User_feed_id:String,var image:String,var created_on:String) {

  @JvmName("getImage1")
  fun getImage():String{
      return image
  }

}