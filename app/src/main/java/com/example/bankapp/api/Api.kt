package com.example.bankapp.api


import com.example.bankapp.models.UserAccount
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {
    @FormUrlEncoded
    @POST("login")

    fun loginUser(
        @Field("user")user:String,
        @Field("password") password:String
    ):Call<UserAccount>
}