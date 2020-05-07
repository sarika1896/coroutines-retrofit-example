package com.example.mvvmwithcoroutinesexample.presenter

import com.example.mvvmwithcoroutinesexample.model.UserLoginDetails
import dev.ashish.recyclerviewwithviewmodellivedata.retrofit.ApiClient
import dev.ashish.recyclerviewwithviewmodellivedata.retrofit.ApiInterface
import retrofit2.Response


class UserDetailsAPI {
    suspend fun userLogin(email: String, password: String): Response<UserLoginDetails> {

        val service = ApiClient.createService(ApiInterface::class.java)
        val call = service.userLogin(email, password)
        return call
    }
}