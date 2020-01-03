package com.example.framework.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object PhotosApi {

    lateinit var retrofit: Retrofit

    private const val imageUrl: String = "https://jsonplaceholder.typicode.com/"

    fun getRetrofitInstance(): GetDataService {

        retrofit = Retrofit.Builder()
            .baseUrl(imageUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(GetDataService::class.java)
    }
}