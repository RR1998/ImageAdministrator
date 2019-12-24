package com.example.imageadministrator

import androidx.lifecycle.MutableLiveData
import com.example.imageadministrator.network.PhotosApi
import com.example.imageadministrator.models.PhotosModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private val client  = PhotosApi.getRetrofitInstance()

    fun getPhotoData() : MutableLiveData<List<PhotosModel>> {
        val liveData = MutableLiveData<List<PhotosModel>>()
        client.getPhotos().enqueue(object : Callback<List<PhotosModel>> {
            override fun onResponse(call: Call<List<PhotosModel>>, response: Response<List<PhotosModel>>) {

                liveData.value = response.body()
            }
            override fun onFailure(call: Call<List<PhotosModel>>, t: Throwable) {
            }
        })
        return  liveData
    }
}