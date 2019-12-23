package com.example.imageadministrator.network

data class PhotosModel(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)