package com.example.mydaggerapplication

import android.os.Bundle
import android.util.Log
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.mydaggerapplication.component.UserComponent
import com.example.mydaggerapplication.databinding.ActivityMainBinding

import com.example.mydaggerapplication.model.ApiInterfaces
import com.example.mydaggerapplication.model.UserModel

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var todoApi: ApiInterfaces? = null
    private val TAG = "MainActivity"
    lateinit var userComponent: UserComponent

    @Inject
    lateinit var retrofit: Retrofit
   // private var todoApi: TodoApi? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
       (application as MyApplication).getNetComponent()?.inject(this)

//        mApiComponent = DaggerUserComponent.builder()
//            .userModule( UserModule(application))
//            .aPIModule(APIModule("https://reqres.in/api/users?page=1"))
//            .build()
//       // mApiComponent.provideRetrofit()?.getClient
//                    val call: Call<UserModel>? = todoApi?.getall("", "10")
//        call?.enqueue(object : Callback<UserModel> {
//            override fun onFailure(call: Call<UserModel>, t: Throwable) {
//                //progerssProgressDialog.dismiss()
//            }
//
//            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
//                //progerssProgressDialog.dismiss()
//                val usermodel: UserModel? = response.body();
//    //                list.layoutManager = LinearLayoutManager(activity)
//    //                list.adapter = activity?.let {
//    //                    UserAdapter(
//    //                        it, usermodel?.data as List<UserDataModel>
//    //                    )
//    //                }
//            }
//        })

//        todoApi = retrofit.create(ApiInterfaces::class.java)
//    todoApi?.getall()?.enqueue(object :Callback<UserModel>{
//        override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
//           val dataResponse=response.body() as UserModel
//            Log.d(TAG, "onResponse: "+dataResponse.total)
//        }
//
//        override fun onFailure(call: Call<UserModel>, t: Throwable) {
//            Log.d(TAG, "onFailure: "+t.message)
//        }
//    })
    }
    private fun getHeroes() {

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}