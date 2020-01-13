package com.example.imageadministrator.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.domain.PhotosCleanModel
import com.example.imageadministrator.eventhandler.Event

/**
 * PhotosViewModel is the class that executes the onClick method that changes the class values
 * from clickEvent variable and triggers the DetailView
 */
class PhotosViewModel(
    var photoItem: PhotosCleanModel,
    private var clickEvent: MutableLiveData<Event<PhotosCleanModel>>
) : ViewModel() {

    fun onClick() {

        clickEvent.value = Event(photoItem)
    }
}