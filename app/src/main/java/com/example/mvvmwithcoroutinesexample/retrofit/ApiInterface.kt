package dev.ashish.recyclerviewwithviewmodellivedata.retrofit

import com.example.mvvmwithcoroutinesexample.model.UserLoginDetails
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String): Response<UserLoginDetails>

}

