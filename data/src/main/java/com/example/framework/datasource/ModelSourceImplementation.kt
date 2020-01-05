package com.example.framework.datasource

import androidx.lifecycle.MutableLiveData
import com.example.core.domain.PhotosCleanModel
import com.example.core.repository.PhotosDataSource
import com.example.framework.database.databaseapplication.DatabaseApplication
import com.example.framework.models.PhotosResponseModel
import com.example.framework.remote.PhotosApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//private val database: PhotosGetDatabase?
class ModelSourceImplementation : PhotosDataSource {

    var databaseApplicationInstance = DatabaseApplication()

    override fun getPhotoData(): MutableLiveData<List<PhotosCleanModel>> {

        val liveDataCleanList = MutableLiveData<List<PhotosCleanModel>>()
        val liveData = MutableLiveData<List<PhotosResponseModel>>()
        val client = PhotosApi.getRetrofitInstance()

        client.getPhotos().enqueue(object : Callback<List<PhotosResponseModel>> {

            val cleanList = mutableListOf<PhotosCleanModel>()

            override fun onResponse(
                call: Call<List<PhotosResponseModel>>,
                response: Response<List<PhotosResponseModel>>
            ) {
                databaseApplicationInstance.onCreate()
                liveData.value = response.body()
                liveData.value = liveData.value?.subList(0, 24)
                liveData.value?.forEach {
                    cleanList.add(it.responseEntity().cleaner())
                }

                databaseApplicationInstance.uiScope.launch {
                    databaseApplicationInstance.savePhotos(response.body())
                }
                /*val listItems: MutableList<PhotosEntityModel> = mutableListOf()
                databaseApplicationInstance.database.daoInterface().getPhotos().forEach {
                    listItems.add(it)
                }*/

                liveDataCleanList.value = cleanList
            }

            override fun onFailure(call: Call<List<PhotosResponseModel>>, t: Throwable) {
            }

        })
        return liveDataCleanList
    }
}
