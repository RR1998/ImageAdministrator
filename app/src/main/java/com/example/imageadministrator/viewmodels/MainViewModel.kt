package com.example.imageadministrator.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.framework.database.PhotosGetDatabase
import com.example.framework.datasource.ModelSourceImplementation
import com.example.framework.models.PhotosEntityModel
import com.example.framework.models.PhotosResponseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel(private val database: PhotosGetDatabase?) : ViewModel() {

    @Suppress("zero parameters constructor error")
    constructor() : this(
        database = null
    )

    var itemClickEvent: MutableLiveData<PhotosEntityModel> = MutableLiveData()

    private var dataListModelSourceImplementation: ModelSourceImplementation =
        ModelSourceImplementation(database)

    private var mainViewModelJob = Job()

    private var uiScope = CoroutineScope(Dispatchers.Main + mainViewModelJob)

    override fun onCleared() {
        super.onCleared()
        mainViewModelJob.cancel()
    }

    fun getListPhoto(): MutableLiveData<List<PhotosResponseModel>> {

        val dataList = dataListModelSourceImplementation.getPhotoData()

        uiScope.launch {
            dataListModelSourceImplementation.insertPhotos()
        }

        return dataList
    }
}