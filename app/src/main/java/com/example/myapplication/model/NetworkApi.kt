package com.example.myapplication.model

import com.example.myapplication.model.Json
import retrofit2.Call
import retrofit2.http.GET

interface NetworkApi {

    @GET("posts")
    fun getPosts() : Call<List<Json>>

}
