//package com.example.mydaggerapplication.viewModel
//
//import com.example.mydaggerapplication.module.APIModule
//
//import com.example.mydaggerapplication.ui.home.HomeViewModel
//import dagger.Component
//import javax.inject.Singleton
//
//@Singleton
//@Component(modules = [(APIModule::class)])
//  interface ViewModelInjector {
//    /**
//     * Injects required dependencies into the specified PostListViewModel.
//     * @param postListViewModel PostListViewModel in which to inject the dependencies
//     */
//    fun inject(postListViewModel: PostViewModel)
//
//    @Component.Builder
//    interface Builder {
//        fun build(): ViewModelInjector
//
//        fun networkModule(userModule: APIModule): Builder
//    }
//}