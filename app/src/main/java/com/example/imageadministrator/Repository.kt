package com.example.imageadministrator

import androidx.lifecycle.MutableLiveData
import com.example.imageadministrator.database.PhotosDatabase
import com.example.imageadministrator.models.PhotosModel
import com.example.imageadministrator.network.PhotosApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val database: PhotosDatabase?) {

    private val client = PhotosApi.getRetrofitInstance()

    val liveData = MutableLiveData<List<PhotosModel>>()

    fun getPhotoData(): MutableLiveData<List<PhotosModel>> {


        client.getPhotos().enqueue(object : Callback<List<PhotosModel>> {

            override fun onResponse(
                call: Call<List<PhotosModel>>,
                response: Response<List<PhotosModel>>
            ) {
                liveData.value = response.body()
                liveData.value = liveData.value?.subList(0, 24)
            }

            override fun onFailure(call: Call<List<PhotosModel>>, t: Throwable) {}

        })

        return liveData
    }
}