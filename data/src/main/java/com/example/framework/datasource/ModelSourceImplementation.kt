package com.example.framework.datasource

import androidx.lifecycle.MutableLiveData
import com.example.framework.database.PhotosGetDatabase
import com.example.framework.models.PhotosEntityModel
import com.example.framework.models.PhotosResponseModel
import com.example.framework.remote.PhotosApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelSourceImplementation(private val database: PhotosGetDatabase?) {

    val liveData = MutableLiveData<List<PhotosResponseModel>>()

    fun getPhotoData(): MutableLiveData<List<PhotosResponseModel>> {
        val client = PhotosApi.getRetrofitInstance()

        client.getPhotos().enqueue(object : Callback<List<PhotosResponseModel>> {

            override fun onResponse(
                call: Call<List<PhotosResponseModel>>,
                response: Response<List<PhotosResponseModel>>
            ) {
                liveData.value = response.body()
                liveData.value = liveData.value?.subList(0, 24)
                liveData.value?.forEach {
                    database?.daoInterface()?.insert(it.responseEntity())
                }
                val listItems: MutableList<PhotosEntityModel> = mutableListOf()
                database?.daoInterface()?.getPhotos()?.forEach {
                    listItems.add(it)
                }
            }

            override fun onFailure(call: Call<List<PhotosResponseModel>>, t: Throwable) {
            }

        })

        return liveData
    }
}
