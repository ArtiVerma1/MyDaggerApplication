package com.example.mydaggerapplication.component

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mydaggerapplication.model.DataItem
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {


    @Query("SELECT * FROM DataItem")
   fun getAll(): Flow<List<DataItem>>
   @Insert
    fun insertAll(users: DataItem?)

    @Delete
    fun delete(user: DataItem)
}