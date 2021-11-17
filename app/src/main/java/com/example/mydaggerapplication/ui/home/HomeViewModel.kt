package com.example.mydaggerapplication.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.mydaggerapplication.Databases.DatabaseHelper
import com.example.mydaggerapplication.Databases.UserRepos
import com.example.mydaggerapplication.component.UserDao
import com.example.mydaggerapplication.model.ApiInterfaces
import com.example.mydaggerapplication.model.DataItem
import com.example.mydaggerapplication.model.UserModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


public class HomeViewModel ( val retrofit :Retrofit, val db : DatabaseHelper,val repos: UserRepos) : ViewModel(){

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    private var userdata= MutableLiveData<UserModel>().apply {  }
    val text: LiveData<String> = _text
    private var todoApi: ApiInterfaces? = null
    private var dao: UserDao? = null
    private var dataItem= MutableLiveData<DataItem>().apply {  }
    private val TAG = "MainActivity"
//    @Inject
//    lateinit var retrofit: Retrofit

    fun getUser() : LiveData<UserModel>? {
        userdata = getServicesApiCall()
        return userdata
    }
fun insertdata( dataitem1: DataItem?): LiveData<DataItem>{
  //  userdata = getServicesApiCall()
    db.userDao().insertAll(dataitem1)
   // .insertAll(dataitem1)
    return dataItem
}

    fun getServicesApiCall(): MutableLiveData<UserModel> {

       todoApi = retrofit.create(ApiInterfaces::class.java)
        val response= todoApi?.getall()
        response?.enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                val dataResponse = response.body() as UserModel
                userdata.postValue(response.body())

            //    dao?.insertAll(dataResponse);
//                list.layoutManager = LinearLayoutManager(activity)
//                  list.adapter = activity?.let {
//                        UserAdapter(
//                           it, usermodel?.data as List<UserDataModel>
//                       )
                //  (response.body() as UserModel).also { userdata = it }
                Log.d(TAG, "onResponse: " + dataResponse.total)

            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Log.d(TAG, "onFailure: " + t.message)
            }
        })
        return userdata
   }
    val allWords: LiveData<List<DataItem>> = repos.allWords.asLiveData()
    fun insert(word: DataItem) = CoroutineScope(Dispatchers.IO).launch {
        repos.insert(word)
    }
}