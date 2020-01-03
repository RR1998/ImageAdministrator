package com.example.imageadministrator.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.framework.models.PhotosEntityModel

class PhotosViewModel(
    var photoItem: PhotosEntityModel,
    private var clickEvent: MutableLiveData<PhotosEntityModel>
) : ViewModel() {

    fun onClick() {

        clickEvent.value = photoItem

    }

}