package com.example.core.interactors

import com.example.core.repository.PhotosDataSourceRepository

class GetPhotos(private val photosRepository: PhotosDataSourceRepository) {
    operator fun invoke() = photosRepository.getPhotoData()
}