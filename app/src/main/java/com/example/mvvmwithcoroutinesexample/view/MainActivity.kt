package com.example.mvvmwithcoroutinesexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmwithcoroutinesexample.R
import com.example.mvvmwithcoroutinesexample.databinding.ActivityMainBinding
import com.example.mvvmwithcoroutinesexample.model.User
import com.example.mvvmwithcoroutinesexample.viewmodel.UserViewModel

class MainActivity : AppCompatActivity(), IMainActivityView {

    private val userViewModel by lazy {
        ViewModelProviders.of(this).get(UserViewModel::class.java)
    }
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        activityMainBinding.setLifecycleOwner(this)
        activityMainBinding.loginmodel = userViewModel

        userViewModel.iMainActivityView = this

    }

    override fun onSucess(resultData: User) {

        activityMainBinding.textviewData.setText(resultData.name)
        Toast.makeText(this, "Login suceessful", Toast.LENGTH_LONG).show()
    }

    override fun onFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
