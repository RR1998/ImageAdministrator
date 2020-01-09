package com.example.imageadministrator.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.domain.PhotosCleanModel
import com.example.core.interactors.GetPhotos
import com.example.imageadministrator.eventhandler.Event

/**
 * MainViewModel its the class that calls the useCase to fill the view
 */
class MainViewModel(private var useCase: GetPhotos) : ViewModel() {

    var itemClickEvent: MutableLiveData<Event<PhotosCleanModel>> = MutableLiveData()

    fun getListPhoto(): MutableLiveData<List<PhotosCleanModel>> = useCase.invoke()
}