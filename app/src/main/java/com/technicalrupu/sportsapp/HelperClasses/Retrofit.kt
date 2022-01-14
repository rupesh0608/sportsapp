package com.technicalrupu.sportsapp.HelperClasses

import com.technicalrupu.sportsapp.HelperClasses.Interface.AuthInterceptor
import com.technicalrupu.sportsapp.HelperClasses.Interface.MyApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit() {
      fun  create():MyApi{

          val client =  OkHttpClient.Builder()
              .addInterceptor(AuthInterceptor("admin","1234"))
              .build()
        val retrofit = Retrofit.Builder().client(client)
            .baseUrl("http://demo2.ongraph.com/demo/pixprt/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(MyApi::class.java)
    }
}


