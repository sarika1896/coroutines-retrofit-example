package com.example.mvvmwithcoroutinesexample.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmwithcoroutinesexample.Coroutines
import com.example.mvvmwithcoroutinesexample.presenter.UserDetailsAPI
import com.example.mvvmwithcoroutinesexample.view.IMainActivityView
import java.lang.Exception

class UserViewModel : ViewModel() {

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    var iMainActivityView: IMainActivityView? = null

    fun onClick(view: View) {
        if (email.value.isNullOrEmpty() || password.value.isNullOrEmpty()) {
            iMainActivityView?.onFailure("Please Enter data")
            return
        }
        Coroutines.main {
            try {
                val userDetailsApi = UserDetailsAPI()
                val response = userDetailsApi.userLogin(email.value!!, password.value!!)

                if (response.isSuccessful) {
                    iMainActivityView?.onSucess(response.body()?.user!!)
                } else {
                    iMainActivityView?.onFailure("Error valid data " + response.code())
                }
            } catch (e: Exception) {
                iMainActivityView?.onFailure(e.toString())
            }

        }

    }

}