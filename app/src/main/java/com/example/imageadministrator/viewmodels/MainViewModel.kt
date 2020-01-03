package com.example.imageadministrator.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.framework.datasource.Repository
import com.example.framework.database.PhotosDatabase
import com.example.framework.models.PhotosEntityModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel(private val database: PhotosDatabase?) : ViewModel() {

    @Suppress("zero parameters constructor error")
    constructor() : this(
        database = null
    )

    var itemClickEvent: MutableLiveData<PhotosEntityModel> = MutableLiveData()

    private var dataListRepository: Repository =
        Repository(database)

    private var mainViewModelJob = Job()

    private var uiScope = CoroutineScope(Dispatchers.Main + mainViewModelJob)

    override fun onCleared() {
        super.onCleared()
        mainViewModelJob.cancel()
    }

    fun getListPhoto(): MutableLiveData<List<PhotosEntityModel>> {

        val dataList = dataListRepository.getPhotoData()

        uiScope.launch {
            dataListRepository.insertPhotos()
        }

        return dataList
    }
}