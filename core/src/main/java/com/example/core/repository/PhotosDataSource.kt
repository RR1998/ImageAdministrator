package com.example.core.repository

import androidx.lifecycle.MutableLiveData
import com.example.core.domain.PhotosCleanModel

interface PhotosDataSource {
    suspend fun getPhoto(): MutableLiveData<List<PhotosCleanModel>>
}