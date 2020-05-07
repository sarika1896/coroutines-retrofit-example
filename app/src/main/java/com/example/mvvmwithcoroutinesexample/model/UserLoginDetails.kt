package com.example.mvvmwithcoroutinesexample.model

data class UserLoginDetails(
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User?
)