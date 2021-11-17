//package com.example.mydaggerapplication.viewModel
//
//import androidx.lifecycle.ViewModel
//import com.example.mydaggerapplication.module.APIModule
//
//import com.example.mydaggerapplication.ui.home.HomeViewModel
//
//abstract class BaseViewModel : ViewModel(){
//    private val injector: ViewModelInjector = DaggerViewModelInjector
//        .builder()
//        .apiModule(APIModule("https://reqres.in/"))
//        .build()
//
//    init {
//        inject()
//    }
//
//    /**
//     * Injects the required dependencies
//     */
//    private fun inject() {
//        when (this) {
//            is PostViewModel -> injector.inject(this)
//        }
//    }
//}