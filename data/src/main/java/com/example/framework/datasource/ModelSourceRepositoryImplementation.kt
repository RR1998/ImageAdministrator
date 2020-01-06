package com.example.framework.datasource

import androidx.lifecycle.MutableLiveData
import com.example.core.domain.PhotosCleanModel
import com.example.core.repository.PhotosDataSourceRepository
import com.example.framework.database.PhotosGetDatabase
import com.example.framework.models.PhotosResponseModel
import com.example.framework.remote.PhotosApi
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * ModelSourceRepositoryImplementation uses the api and database instances to download and return the items to show in the views
 */

class ModelSourceRepositoryImplementation(val client: PhotosApi, var database: PhotosGetDatabase) :
    PhotosDataSourceRepository {

    private var insertDatabaseJob = Job()

    var uiScope = CoroutineScope(Dispatchers.Main + insertDatabaseJob)

    override fun getPhotoData(): MutableLiveData<List<PhotosCleanModel>> {
        val liveDataCleanList = MutableLiveData<List<PhotosCleanModel>>()
        val liveData = MutableLiveData<List<PhotosResponseModel>>()
        val clientInstance = client.getRetrofitInstance()
        clientInstance.getPhotos().enqueue(object : Callback<List<PhotosResponseModel>> {

            val cleanList = mutableListOf<PhotosCleanModel>()

            override fun onResponse(
                call: Call<List<PhotosResponseModel>>,
                response: Response<List<PhotosResponseModel>>
            ) {
                liveData.value = response.body()
                liveData.value = liveData.value?.subList(0, 24)
                liveData.value?.forEach {
                    cleanList.add(it.mapper().mapper())
                }

                uiScope.launch {
                    savePhotos(response.body())
                }

                liveDataCleanList.value = cleanList
            }

            override fun onFailure(call: Call<List<PhotosResponseModel>>, t: Throwable) {}
        })
        return liveDataCleanList
    }

    suspend fun savePhotos(cleanList: List<PhotosResponseModel>?) {
        withContext(Dispatchers.IO) {
            cleanList?.forEach {
                database.daoInterface().insert(it.mapper())
            }
        }
    }
}
