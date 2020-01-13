package com.example.core.interactors

import com.example.core.repository.PhotosDataSourceRepository

/**
 * GetPhotos class is the class that is invoked in the MainViewModel and returns it
 * a List to fill the MainActivity view
 */
class GetPhotos(private val photosRepository: PhotosDataSourceRepository) {

    operator fun invoke() = photosRepository.getPhotoData()
}