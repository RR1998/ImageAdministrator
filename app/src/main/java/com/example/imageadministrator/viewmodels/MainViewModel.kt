package com.example.imageadministrator.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.domain.PhotosCleanModel
import com.example.framework.database.PhotosGetDatabase
import com.example.framework.datasource.ModelSourceImplementation
import kotlinx.coroutines.Job

class MainViewModel(private val database: PhotosGetDatabase?) : ViewModel() {

    @Suppress("zero parameters constructor error")
    constructor() : this(
        database = null
    )

    var itemClickEvent: MutableLiveData<PhotosCleanModel> = MutableLiveData()

    private var dataListModelSourceImplementation: ModelSourceImplementation =
        ModelSourceImplementation(database)

    private var mainViewModelJob = Job()


    override fun onCleared() {
        super.onCleared()
        mainViewModelJob.cancel()
    }

    fun getListPhoto(): MutableLiveData<List<PhotosCleanModel>> {

        return dataListModelSourceImplementation.getPhotoData()
    }
}