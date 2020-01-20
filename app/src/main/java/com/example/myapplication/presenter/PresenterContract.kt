package com.example.myapplication.presenter

import com.example.myapplication.model.Json
import com.example.myapplication.view.MainActivity

interface PresenterContract {
    fun initView(view: MainActivity)
    fun destroyView()
    fun seeData()
    fun sendData(data: List<Json>)
    fun sendError(errorMessage: String)
}