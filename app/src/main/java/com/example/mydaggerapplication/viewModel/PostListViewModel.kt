//package com.example.mydaggerapplication.viewModel
//
//import android.util.Log
//import android.view.View
//import androidx.lifecycle.MutableLiveData
//import com.example.mydaggerapplication.adapter.UserAdapter
//import com.example.mydaggerapplication.component.UserDao
//import com.example.mydaggerapplication.model.ApiInterfaces
//import com.example.mydaggerapplication.model.UserModel
//import io.reactivex.Observable
//import io.reactivex.disposables.Disposable
//import io.reactivex.rxjava3.schedulers.Schedulers
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import javax.inject.Inject
//
//class PostListViewModel (private val postDao: UserDao):BaseViewModel(){
////    @Inject
////    lateinit var postApi: PostApi
//    val postListAdapter: UserAdapter = UserAdapter()
//
//    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
//    val errorMessage:MutableLiveData<Int> = MutableLiveData()
//    val errorClickListener = View.OnClickListener { loadPosts() }
//    private var todoApi: ApiInterfaces? = null
//    private val TAG = "MainActivity"
//    @Inject
//    lateinit var retrofit: Retrofit
//    private lateinit var subscription: Disposable
//
//    init{
//        loadPosts()
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        subscription.dispose()
//    }
//
//    private fun loadPosts(){
//        subscription = Observable.fromCallable { postDao.getAll() }
//            .concatMap {
//                    dbPostList ->
//                if(dbPostList.isEmpty())
//                    todoApi?.getall().concatMap {
//                            apiPostList -> postDao.insertAll(*apiPostList.toTypedArray())
//                        Observable.just(apiPostList)
//                    }
//                else
//                    Observable.just(dbPostList)
//            }
//           // .subscribeOn(Schedulers.io())
//         //   .observeOn(AndroidSchedulers.mainThread())
//            .doOnSubscribe { onRetrievePostListStart() }
//            .doOnTerminate { onRetrievePostListFinish() }
//            .subscribe(
//                { result -> onRetrievePostListSuccess(result) },
//                { onRetrievePostListError() }
//            )
//        todoApi = retrofit.create(ApiInterfaces::class.java)
//        todoApi?.getall()?.enqueue(object : Callback<UserModel> {
//            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
//                val dataResponse=response.body() as UserModel
//                Log.d(TAG, "onResponse: "+dataResponse.total)
//
//            }
//
//            override fun onFailure(call: Call<UserModel>, t: Throwable) {
//                Log.d(TAG, "onFailure: "+t.message)
//            }
//        })
//    }
//
//    private fun onRetrievePostListStart(){
//        loadingVisibility.value = View.VISIBLE
//        errorMessage.value = null
//    }
//
//    private fun onRetrievePostListFinish(){
//        loadingVisibility.value = View.GONE
//    }
//
//    private fun onRetrievePostListSuccess(postList:List<UserModel>){
//        //postListAdapter.updatePostList(postList)
//    }
//
//    private fun onRetrievePostListError(){
//        //errorMessage.value = R.string.post_error
//    }
//}