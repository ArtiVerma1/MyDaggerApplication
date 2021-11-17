//package com.example.mydaggerapplication.ui.home
//
//import android.content.Context
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//
//import androidx.recyclerview.widget.RecyclerView
//import com.example.mydaggerapplication.MainActivity
//import com.example.mydaggerapplication.MyApplication
//import com.example.mydaggerapplication.databinding.FragmentHomeBinding
//import com.example.mydaggerapplication.model.UserModel
//import retrofit2.Retrofit
//import javax.inject.Inject
//
//
//class HomeFragment : Fragment() {
//
//    private lateinit var homeViewModel: HomeViewModel
//    private var _binding: FragmentHomeBinding? = null
//    private var mContext: Context? = null
//    private var application: MyApplication? = null
//    // This property is only valid between onCreateView and
//    // onDestroyView.
//    private val TAG = "home"
//        @Inject
//    lateinit var retrofit: Retrofit
//    private val binding get() = _binding!!
//    private  val applica: MyApplication?=null
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        mContext = context
//    }
//
//    override fun onCreateView(
//            inflater: LayoutInflater,
//            container: ViewGroup?,
//            savedInstanceState: Bundle?
//    ): View? {
//       // (application as MyApplication).getNetComponent()!!.inject(this)
////        var factory = object : ViewModelProvider.Factory {
////            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
////                return  HomeViewModel(retrofit) as T
////            }
////        }
//        homeViewModel =
//                ViewModelProvider(this, factory).get(HomeViewModel::class.java)
//
//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//      //application=  (application as MyApplication).getNetComponent()?.inject(this)
//
//      //  (getApplication() as MyApplication).getNetworkComponent().inject(this)
////        val textView: TextView = binding.textHome
////        homeViewModel.text.observe(viewLifecycleOwner, Observer {
////            textView.text = it
////        })
//
//
//       // (applicationContext as MyApplication).getNetComponent()?.inject(this)
//        val list :RecyclerView= _binding!!.list
//        homeViewModel.getUser()?.observe(viewLifecycleOwner, Observer { serviceSetterGetter ->
//            val dataResponse=serviceSetterGetter.totalPages
//            Log.d(TAG, "onResponse: "+dataResponse)
//
//           // val msg = serviceSetterGetter.message
//
//         //   lblResponse.text = msg
//
//        })
//
//
////        val component: UserComponent =
////            DaggerUserComponent.builder().userModule(UserModule()).apimodule(APIModule("https://reqres.in/api/users?page=1")).build()
//        //vehicle = component.provideRestClient()
////        val call: Call<UserModel> = component.getClient!!.getall("", "10")
////        call.enqueue(object : Callback<UserModel> {
////            override fun onFailure(call: Call<UserModel>, t: Throwable) {
////                //progerssProgressDialog.dismiss()
////            }
////
////            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
////                //progerssProgressDialog.dismiss()
////                val usermodel: UserModel? = response.body();
////                list.layoutManager = LinearLayoutManager(activity)
////                list.adapter = activity?.let {
////                    UserAdapter(
////                        it, usermodel?.data as List<UserDataModel>
////                    )
////                }
////            }
////        })
//
//
//        return root
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}