//package com.example.mydaggerapplication.obj2
//
//import android.util.Log
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.example.mydaggerapplication.model.ApiInterfaces
//import com.example.mydaggerapplication.model.UserModel
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import javax.inject.Inject
//
//object MainRespos1 {
//    val userdata = MutableLiveData<UserModel>()
//    //val text: LiveData<String> = _text
//    private var todoApi: ApiInterfaces? = null
//    private val TAG = "MainActivity"
//    @Inject
//    lateinit var retrofit1: Retrofit
//    fun getServicesApiCall(): MutableLiveData<UserModel> {
//
//        todoApi = retrofit1.create(ApiInterfaces::class.java)
//        val response=todoApi?.getall()
//        response?.enqueue(object : Callback<UserModel> {
//            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
//                val dataResponse = response.body() as UserModel
//                userdata.postValue(response.body())
////                list.layoutManager = LinearLayoutManager(activity)
////                  list.adapter = activity?.let {
////                        UserAdapter(
////                           it, usermodel?.data as List<UserDataModel>
////                       )
//                //  (response.body() as UserModel).also { userdata = it }
//                Log.d(TAG, "onResponse: " + dataResponse.total)
//
//            }
//
//            override fun onFailure(call: Call<UserModel>, t: Throwable) {
//                Log.d(TAG, "onFailure: " + t.message)
//            }
//        })
//        return userdata
//    }
//}