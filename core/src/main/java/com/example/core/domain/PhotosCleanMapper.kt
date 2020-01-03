package com.example.core.domain

import com.example.core.domain.PhotosCleanModel

interface PhotosCleanMapper{
    fun cleaner(id: Int, albumId: Int, title: String, url: String, thumbnailUrl: String):PhotosCleanModel
}