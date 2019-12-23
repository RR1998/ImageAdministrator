package com.example.imageadministrator.network

import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {
    @GET("photos")
    fun getPhotos(): Call<List<PhotosModel>>
}