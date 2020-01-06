package com.example.imageadministrator.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.domain.PhotosCleanModel
import com.example.core.interactors.GetPhotos
import kotlinx.coroutines.Job

class MainViewModel(var useCase: GetPhotos) : ViewModel() {

    var itemClickEvent: MutableLiveData<PhotosCleanModel> = MutableLiveData()

    private var mainViewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        mainViewModelJob.cancel()
    }

    fun getListPhoto(): MutableLiveData<List<PhotosCleanModel>> = useCase.invoke()
}