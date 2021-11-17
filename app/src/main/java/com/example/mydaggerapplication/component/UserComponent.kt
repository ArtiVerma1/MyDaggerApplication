package com.example.mydaggerapplication.component


import com.example.mydaggerapplication.Activities.ListActivity
import dagger.Component
import dagger.Module
import javax.inject.Singleton
import com.example.mydaggerapplication.MainActivity

import com.example.mydaggerapplication.module.APIModule
import com.example.mydaggerapplication.module.DatabaseModule

@Component(modules = [APIModule::class, DatabaseModule::class])
@Singleton
interface UserComponent {
  // public fun provideRetrofit(): Retrofitobj?

 // open fun getRetrofit(): Retrofit?
     fun inject(activity: MainActivity)
    fun inject(activity1: ListActivity)
    //fun inject(homefrag: HomeFragment)
   // fun inject(viewhome: HomeViewModel)
}
