package com.example.mydaggerapplication.Databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mydaggerapplication.component.UserDao
import com.example.mydaggerapplication.model.DataItem
import com.example.mydaggerapplication.model.UserModel
import dagger.Provides


@Database(entities = [DataItem::class], version = 2)
public abstract class DatabaseHelper : RoomDatabase(){
    abstract fun userDao(): UserDao
//    companion object {
//        // Singleton prevents multiple instances of database opening at the
//        // same time.
//        @Volatile
//        private var INSTANCE: DatabaseHelper? = null
//
//     public   fun getDatabase(context: Context): DatabaseHelper {
//            // if the INSTANCE is not null, then return it,
//            // if it is, then create the database
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    DatabaseHelper::class.java,
//                    "word_database"
//                ).build()
//                INSTANCE = instance
//                // return instance
//                instance
//            }
//        }
//    }
}