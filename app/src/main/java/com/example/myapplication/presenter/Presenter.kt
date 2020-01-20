package com.example.myapplication.presenter

import com.example.myapplication.model.Json
import com.example.myapplication.model.Network
import com.example.myapplication.view.MainActivity
import com.example.myapplication.view.ViewContract

class Presenter : PresenterContract{

    var view: ViewContract? = null

    override fun initView(view: MainActivity) {
        this.view = view
    }

    override fun destroyView() {
        view = null
    }

    override fun seeData() {
        Network().initRetrofit()
    }

    override fun sendData(data: List<Json>) {
        view?.passData(data)
    }

    override fun sendError(errorMessage: String) {
        view?.getErrorMessage(errorMessage)
    }
}