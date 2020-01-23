package com.example.imageadministrator.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.core.domain.PhotosCleanModel
import com.example.core.interactors.GetPhotos
import com.example.framework.datasource.ModelSourceRepositoryImplementation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.*

@ExperimentalCoroutinesApi
class MainViewModelTest {

    lateinit var useCase: GetPhotos
    lateinit var photosRepository: ModelSourceRepositoryImplementation
    lateinit var mainViewModelInstance: MainViewModel
    private val testDispatcher = TestCoroutineDispatcher()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        // Given:
        Dispatchers.setMain(testDispatcher)
        runBlocking {
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
            photosRepository = mock(ModelSourceRepositoryImplementation::class.java)
            `when`(photosRepository.getPhotoData()).thenReturn(photosLiveDataList)
            useCase = GetPhotos(photosRepository)
            mainViewModelInstance = MainViewModel(useCase)
        }
    }


    @Test
    fun `when getting list of photos, repository is invoked`() {
        runBlocking {
            // When:
            mainViewModelInstance.getListPhoto()

            // Then:
            verify(photosRepository).getPhotoData()
        }
    }

    @Test
    fun `when getting list of photos, actual list is returned`() {
        // When:
        val photoListLiveData = mainViewModelInstance.getListPhoto()

        // Then:
        Assert.assertEquals(photoListLiveData.value?.get(0)?.albumId, 1)
        Assert.assertEquals(
            photoListLiveData.value?.get(0)?.url,
            "https://via.placeholder.com/600/92c952"
        )
    }
}