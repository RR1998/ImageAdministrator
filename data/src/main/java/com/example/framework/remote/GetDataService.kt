package com.example.framework.remote

import com.example.framework.models.PhotosResponseModel
import retrofit2.Call
import retrofit2.http.GET

/**
 * GetDataService implements the Get annotation from retrofit to give this functionality
 * to getPhotos function
 */

interface GetDataService {

    @GET("photos")
    fun getPhotos(): Call<List<PhotosResponseModel>>

}