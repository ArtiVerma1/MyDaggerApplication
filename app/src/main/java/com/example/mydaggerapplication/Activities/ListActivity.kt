package com.example.mydaggerapplication.Activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mydaggerapplication.Databases.DatabaseHelper
import com.example.mydaggerapplication.Databases.UserRepos
import com.example.mydaggerapplication.MyApplication
import com.example.mydaggerapplication.adapter.UserAdapter
import com.example.mydaggerapplication.component.UserDao
import com.example.mydaggerapplication.databinding.FragmentHomeBinding
import com.example.mydaggerapplication.model.DataItem
import com.example.mydaggerapplication.model.UserModel
import com.example.mydaggerapplication.ui.home.HomeViewModel
import retrofit2.Retrofit
import javax.inject.Inject

class ListActivity : AppCompatActivity() {
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private var mContext: Context? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val TAG = "home"
    @Inject
    lateinit var retrofit: Retrofit
    private var dao: UserDao? = null
   @Inject
   lateinit var db: DatabaseHelper
    private val binding get() = _binding!!
    var usermodel: UserModel? = null
    lateinit var dataitem: List<DataItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_list)
        val repository by lazy { UserRepos(db.userDao()) }
        (application as MyApplication).getNetComponent()?.inject(this)

        var factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return  HomeViewModel(retrofit,db,repository) as T
            }
        }
        homeViewModel =
            ViewModelProvider(this, factory).get(HomeViewModel::class.java)
//        homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
      //  val root: View = binding.
        val list : RecyclerView = _binding!!.list


        homeViewModel.getUser()?.observe(this, Observer { serviceSetterGetter ->
            val dataResponse=serviceSetterGetter.totalPages
            Log.d(TAG, "onResponse: "+dataResponse)


             usermodel = serviceSetterGetter
            for (i in 0 until usermodel?.data?.size!!){

//                val builder = AlertDialog.Builder(this)
//                //set title for alert dialog
//                builder.setTitle("ok")
//                //set message for alert dialog
//                builder.setMessage("check")
//                builder.setIcon(android.R.drawable.ic_dialog_alert)
//
//                //performing positive action
//                builder.setPositiveButton("Yes"){dialogInterface, which ->
                    usermodel?.data?.get(i)?.let { homeViewModel.insert(it) }
                    homeViewModel.allWords.observe(this) { words ->
                        // Update the cached copy of the words in the adapter.
                        //   words.let { adapter.submitList(it) }
                        //  dataitem = words
//                        list.layoutManager = LinearLayoutManager(applicationContext)
//                        list.adapter = applicationContext?.let {
//                            UserAdapter(
//                                it, words
//                            )
//                        }
                      //  Toast.makeText(applicationContext,words.get(0).firstName,Toast.LENGTH_LONG).show()
                    }

                }
                //performing cancel action
//                builder.setNeutralButton("Cancel"){dialogInterface , which ->
//                    Toast.makeText(applicationContext,"clicked cancel\n operation cancel",Toast.LENGTH_LONG).show()
//                }
//                //performing negative action
//                builder.setNegativeButton("No"){dialogInterface, which ->
//                    Toast.makeText(applicationContext,"clicked No",Toast.LENGTH_LONG).show()
//                }
//                // Create the AlertDialog
//                val alertDialog: AlertDialog = builder.create()
//                // Set other dialog properties
//                alertDialog.setCancelable(false)
//                alertDialog.show()
           // }
            // homeViewModel.insertdata(usermodel?.data?.get(i))
                //db.userDao().insertAll(serviceSetterGetter.data.get(i))

                    list.layoutManager = LinearLayoutManager(applicationContext)
                    list.adapter = applicationContext?.let {
                        UserAdapter(
                            it, usermodel?.data as List<DataItem>
                        )
                    }
           // usermodel?.data?.get(0)?.let { homeViewModel.insert(it) }
           // val usermodel1 =  db.userDao().getAll()
          //  val offlinelist: UserModel?= dao?.getAll()

        })

        homeViewModel.allWords.observe(this) { words ->
            // Update the cached copy of the words in the adapter.
            //   words.let { adapter.submitList(it) }
            //  dataitem = words
            list.layoutManager = LinearLayoutManager(applicationContext)
            list.adapter = applicationContext?.let {
                UserAdapter(
                    it, words
                )
            }
        }

    }
}