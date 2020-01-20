package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.R
import com.example.myapplication.model.Json
import com.example.myapplication.model.Network
import com.example.myapplication.presenter.Presenter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity(), ViewContract {

    lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPresenter()
        initUI()
    }

    override fun initUI() {
        initJson()
        recylerView.layoutManager = GridLayoutManager(this, 2)
    }

    override fun initPresenter() {
        presenter = Presenter()
        presenter.initView(this)
    }

    override fun initJson() {
        val network = Network.getInstance()
        val api = network.getApi()
        api.getPosts().enqueue(object: Callback, retrofit2.Callback<List<Json>>{
            override fun onFailure(call: Call<List<Json>>, t: Throwable) {
                Log.e("TAG", t.message?: "n/a")
                presenter.sendError(t.message?: "Error, message")
            }

            override fun onResponse(call: Call<List<Json>>, response: Response<List<Json>>) {
                presenter.sendData(response.body()?: emptyList())
            }

        })
    }

    override fun passData(data: List<Json>) {
        recylerView.adapter = CustomAdapter(data)
    }

    override fun getErrorMessage(errorMessage: String) {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroyView()
    }

}
