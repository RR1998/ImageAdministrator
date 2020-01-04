package com.example.core.repository

class PhotosRepository(private val dataSource: PhotosDataSource) {

    fun getPhotos() = dataSource.getPhotoData()
}