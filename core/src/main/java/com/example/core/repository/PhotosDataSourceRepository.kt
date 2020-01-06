package com.example.core.repository

import androidx.lifecycle.MutableLiveData
import com.example.core.domain.PhotosCleanModel

interface PhotosDataSourceRepository {
    fun getPhotoData(): MutableLiveData<List<PhotosCleanModel>>
}