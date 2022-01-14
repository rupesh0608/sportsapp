package com.technicalrupu.sportsapp.HelperClasses.Interface

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor(var user:String,var password:String) :Interceptor {
    private var credentials: String? = Credentials.basic(user, password)

    override fun intercept(chain: Interceptor.Chain): Response? {
        val request: Request = chain.request()
        val authenticatedRequest: Request = request.newBuilder()
            .addHeader("X-API-KEY","anonymous")
            .addHeader("Content-Type","application/json")
            .addHeader("Content-Type","multipart/form-data")
            .addHeader("Type","Basic Auth")
            .addHeader("Authorization", credentials).build()
        return chain.proceed(authenticatedRequest)
    }
}