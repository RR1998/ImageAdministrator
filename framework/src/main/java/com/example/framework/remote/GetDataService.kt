package com.example.framework.remote

import com.example.framework.models.PhotosEntityModel
import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {

    @GET("photos")
    fun getPhotos(): Call<List<PhotosEntityModel>>

}