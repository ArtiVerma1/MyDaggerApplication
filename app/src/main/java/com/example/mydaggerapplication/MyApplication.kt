package com.example.mydaggerapplication

import android.app.Application
import com.example.mydaggerapplication.Databases.DatabaseHelper
import com.example.mydaggerapplication.Databases.UserRepos
import com.example.mydaggerapplication.component.DaggerUserComponent
import com.example.mydaggerapplication.component.UserComponent
import com.example.mydaggerapplication.module.APIModule
import com.example.mydaggerapplication.module.DatabaseModule


class MyApplication : Application() {
     var mApiComponent: UserComponent? = null
    override fun onCreate() {
        super.onCreate()
      ///  val database by lazy { DatabaseHelper.getDatabase(this) }


        mApiComponent = DaggerUserComponent.builder()
           // .userModule( UserModule(this))

            .aPIModule(APIModule("https://reqres.in/"))
           .databaseModule(DatabaseModule(this))
            .build()
    }

    fun getNetComponent(): UserComponent? {
        return mApiComponent

    }
}