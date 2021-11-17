package com.example.mydaggerapplication.module

import com.example.mydaggerapplication.model.ApiInterfaces

import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit


class RetrofitClient {
    private var instance: RetrofitClient? = null
    private var myApi: ApiInterfaces? = null

//    private fun RetrofitClient() {
//        val retrofit: Retrofit =
//            Retrofit.Builder().baseUrl(ApiInterfaces.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        myApi = retrofit.create(ApiInterfaces::class.java)
//    }

    @Synchronized
    fun getInstance(): RetrofitClient? {
        if (instance == null) {

             //   instance = RetrofitClient()


        }
        return instance
    }

    fun getMyApi(): ApiInterfaces? {
        return myApi
    }
}