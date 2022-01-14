package com.technicalrupu.sportsapp.HelperClasses.Interface

import com.technicalrupu.sportsapp.HelperClasses.ApiClasses.*
import retrofit2.Call
import retrofit2.http.*

import okhttp3.MultipartBody
import okhttp3.RequestBody

import kotlin.collections.ArrayList


interface MyApi {

    @POST("authentication/registration")
    @FormUrlEncoded
    fun createUser(
        @Field("user_name") user_name: String,
        @Field("first_name") first_name: String,
        @Field("last_name") last_name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("confirm_password") confirm_password: String,
        @Field("device_token") device_token: String
    ): Call<CreateUser>

    @POST("authentication/login")
    @FormUrlEncoded
    fun login(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("device_token") device_token: String
    ): Call<UserLogin>

    @POST("authentication/forgot_password")
    @FormUrlEncoded
    fun forgotPassword(
        @Field("email") email: String,
    ): Call<CommonResponse>

    @POST("authentication/reset_password")
    @FormUrlEncoded
    fun resetPassword(
        @Field("id") id: Int,
        @Field("old_password") oldPassword: String,
        @Field("new_password") newPassword: String,
        @Field("confirm_password") confirmPassword: String,

        ): Call<CommonResponse>

    @POST("UserFeed/view_userfeed")
    @FormUrlEncoded
    fun viewUserFeed(
        @Field("user_id") user_id: Int,
    ): Call<UserFeed>

    @Multipart
    @POST("UserFeed/add_userfeed")
     fun addNewPost(
        @Part("user_id") user_id: RequestBody,
        @Part("description") description: RequestBody,
        @Part image: MultipartBody.Part,
        @Part("hashtag[]") hashtag: ArrayList<String>,
    ): Call<ImageResponse>
}