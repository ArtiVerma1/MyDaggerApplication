package com.example.mydaggerapplication.Databases

import androidx.annotation.WorkerThread
import com.example.mydaggerapplication.component.UserDao
import com.example.mydaggerapplication.model.DataItem
import com.example.mydaggerapplication.model.UserModel
import kotlinx.coroutines.flow.Flow

class UserRepos(private val wordDao: UserDao)  {
    val allWords : Flow<List<DataItem>> = wordDao.getAll()
   // val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()
    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: DataItem) {
      //  wordDao.insertAll(word)
    }
}