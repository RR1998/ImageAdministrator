package com.example.core.domain

interface PhotosCleanMapper{
    fun cleaner(id: Int, albumId: Int, title: String, url: String, thumbnailUrl: String):PhotosCleanModel
}