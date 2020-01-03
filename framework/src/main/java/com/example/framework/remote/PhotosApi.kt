package com.example.framework.remote

import com.example.framework.datasource.RetrofitInstance
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object PhotosApi:RetrofitInstance {

    lateinit var retrofit: Retrofit

    private const val imageUrl: String = "https://jsonplaceholder.typicode.com/"

    override fun getRetrofitInstance(): GetDataService {

        retrofit = Retrofit.Builder()
            .baseUrl(imageUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(GetDataService::class.java)
    }
}