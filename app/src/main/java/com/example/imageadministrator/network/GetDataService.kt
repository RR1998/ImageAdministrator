package com.example.imageadministrator.network

import com.example.imageadministrator.models.PhotosModel
import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {
    @GET("photos")
    fun getPhotos(): Call<List<PhotosModel>>
}