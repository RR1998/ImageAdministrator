package com.example.imageadministrator.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.domain.PhotosCleanModel

/**
 * PhotosViewModel is the class that executes the onClick method that changes the class values
 * from clickEvent variable and triggers the DetailView
 */

class PhotosViewModel(
    var photoItem: PhotosCleanModel,
    private var clickEvent: MutableLiveData<PhotosCleanModel>
) : ViewModel() {

    fun onClick() {

        clickEvent.value = photoItem

    }

}