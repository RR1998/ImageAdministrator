package com.example.imageadministrator.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.core.domain.PhotosCleanModel
import com.example.core.interactors.GetPhotos
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito

class MainViewModelTest {

    lateinit var useCase: GetPhotos
    lateinit var mainViewModelInstance: MainViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        val photosList = mutableListOf<PhotosCleanModel>()
        val photo = PhotosCleanModel()
        val photosLiveDataList = MutableLiveData<List<PhotosCleanModel>>()
        photo.albumId = 1
        photo.id = 1
        photo.title = "accusamus beatae ad facilis cum similique qui sunt"
        photo.url = "https://via.placeholder.com/600/92c952"
        photo.thumbnailUrl = "https://via.placeholder.com/150/92c952"
        photosList.add(photo)
        photosLiveDataList.value = photosList
        useCase = Mockito.mock(GetPhotos::class.java)
        mainViewModelInstance = MainViewModel(useCase)
        Mockito.`when`(useCase()).thenReturn(photosLiveDataList)
    }


    @Test
    fun getListPhoto() {
        mainViewModelInstance.getListPhoto()
    }
}