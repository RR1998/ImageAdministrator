package com.example.imageadministrator.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imageadministrator.models.PhotosModel

class PhotosViewModel(var photoItem : PhotosModel, var clickEvent: MutableLiveData<PhotosModel>) : ViewModel(){
    fun onClick(){
        clickEvent.value = photoItem
    }
}