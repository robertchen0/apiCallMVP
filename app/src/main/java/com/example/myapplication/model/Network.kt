package com.example.myapplication.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

    // https://jsonplaceholder.typicode.com/posts

    fun initRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getApi() : NetworkApi {
        return initRetrofit().create(NetworkApi::class.java)
    }

    companion object{
        private var instance: Network =
            Network()
        fun getInstance(): Network {
            return instance
        }
    }

}
