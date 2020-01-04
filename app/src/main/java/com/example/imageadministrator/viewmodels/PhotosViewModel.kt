package com.example.imageadministrator.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.domain.PhotosCleanModel

class PhotosViewModel(
    var photoItem: PhotosCleanModel,
    private var clickEvent: MutableLiveData<PhotosCleanModel>
) : ViewModel() {

    fun onClick() {

        clickEvent.value = photoItem

    }

}