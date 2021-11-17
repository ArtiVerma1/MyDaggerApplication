package com.example.mydaggerapplication.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mydaggerapplication.Databases.DatabaseHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
public class DatabaseModule constructor(val con: Context) {


    @Provides
    @Singleton
   internal fun getDatabas(): DatabaseHelper {
        // if the INSTANCE is not null, then return it,
        // if it is, then create the database
        return   Room.databaseBuilder(
            con,
                DatabaseHelper::class.java,
                "user_database"
            ).build()

        }


}