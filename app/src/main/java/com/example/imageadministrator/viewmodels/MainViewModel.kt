package com.example.imageadministrator.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imageadministrator.Repository
import com.example.imageadministrator.models.PhotosModel

class MainViewModel : ViewModel() {

    var itemClickEvent =  MutableLiveData<PhotosModel>()
    var dataList : Repository = Repository()
    fun getListPhoto(): MutableLiveData<List<PhotosModel>> {
        return dataList.getPhotoData()
    }

}