package com.example.core.repository

import androidx.lifecycle.MutableLiveData
import com.example.core.domain.PhotosCleanModel

/**
 * PhotosDataSourceRepository it's an interface that create a getPhotoData function that return
 * a MutableLiveDataList
 */
interface PhotosDataSourceRepository {

    fun getPhotoData(): MutableLiveData<List<PhotosCleanModel>>
}