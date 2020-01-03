package com.example.core.interactors

import com.example.core.repository.PhotosRepository

class GetPhotos(private val photosRepository: PhotosRepository) {
    suspend operator fun invoke() = photosRepository.getPhotos()
}