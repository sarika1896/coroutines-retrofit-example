package com.example.mvvmwithcoroutinesexample.view

import com.example.mvvmwithcoroutinesexample.model.User

interface IMainActivityView {
    fun onSucess(resultData: User)
    fun onFailure(message: String)
}