package com.example.core.interactors

import com.example.core.repository.PhotosRepository

class GetPhotos(private val photosRepository: PhotosRepository) {
    operator fun invoke() = photosRepository.getPhotos()
}