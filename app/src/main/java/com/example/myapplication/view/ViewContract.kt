package com.example.myapplication.view

import com.example.myapplication.model.Json

interface ViewContract {
    fun initUI()
    fun initPresenter()
    fun initJson()
    fun passData(data: List<Json>)
    fun getErrorMessage(errorMessage: String)
}