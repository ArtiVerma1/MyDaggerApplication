package com.example.mydaggerapplication.module

import dagger.Module
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit

import okhttp3.OkHttpClient

import com.google.gson.Gson

import javax.inject.Singleton

import com.google.gson.FieldNamingPolicy

import com.google.gson.GsonBuilder

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mydaggerapplication.Databases.DatabaseHelper

import dagger.Provides
import okhttp3.Cache


@Module
class APIModule constructor(val mBaseUrl: String?) {

    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        return client.build()
    }

    @Provides
    @Singleton
     fun provideGson(): Gson {
        val builder =
            GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return builder.setLenient().create()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(mBaseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
//    @Provides
//    @Singleton
//    internal fun providedb(context: Context): DatabaseHelper {
//        return Room.databaseBuilder(
//            context.applicationContext,
//            DatabaseHelper::class.java,
//            "user_database"
//        ).build()
//    }

    }


