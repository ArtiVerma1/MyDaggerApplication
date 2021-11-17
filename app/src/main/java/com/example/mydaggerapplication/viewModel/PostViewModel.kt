//package com.example.mydaggerapplication.viewModel
//
//import androidx.lifecycle.MutableLiveData
//import com.example.mydaggerapplication.model.UserModel
//
//abstract class PostViewModel :BaseViewModel() {
//    private val postTitle = MutableLiveData<String>()
//    private val postBody = MutableLiveData<String>()
//
//    fun bind(post: UserModel){
//        postTitle.value = post.page.toString()
//       // postBody.value = post.body
//    }
//
//    fun getPostTitle():MutableLiveData<String>{
//        return postTitle
//    }
//
//    fun getPostBody():MutableLiveData<String>{
//        return postBody
//    }
//}