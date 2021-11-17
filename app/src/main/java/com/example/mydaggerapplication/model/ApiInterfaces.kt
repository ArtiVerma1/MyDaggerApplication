package com.example.mydaggerapplication.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterfaces {


    @GET("api/users?page=1")
    fun getall(): Call<UserModel>
}