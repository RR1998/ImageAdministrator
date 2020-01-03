package com.example.framework.datasource

import androidx.lifecycle.MutableLiveData
import com.example.framework.database.PhotosDatabase
import com.example.framework.models.PhotosEntityModel
import com.example.framework.remote.PhotosApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val database: PhotosDatabase?) {

    val liveData = MutableLiveData<List<PhotosEntityModel>>()

    fun getPhotoData(): MutableLiveData<List<PhotosEntityModel>> {
        val client = PhotosApi.getRetrofitInstance()

        client.getPhotos().enqueue(object : Callback<List<PhotosEntityModel>> {

            override fun onResponse(
                call: Call<List<PhotosEntityModel>>,
                response: Response<List<PhotosEntityModel>>
            ) {
                liveData.value = response.body()
                liveData.value = liveData.value?.subList(0, 24)
            }

            override fun onFailure(call: Call<List<PhotosEntityModel>>, t: Throwable) {}

        })

        return liveData
    }

    suspend fun insertPhotos() {

        withContext(Dispatchers.IO) {

            liveData.value?.forEach {
                database?.daoInterface()?.insert(it)
            }
        }
    }
}