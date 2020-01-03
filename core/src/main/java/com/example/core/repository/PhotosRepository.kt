package com.example.core.repository

class PhotosRepository(private val dataSource: PhotosDataSource){

    suspend fun getPhotos() = dataSource.getPhoto()

}