package com.example.core.domain

/**
 * CleanModel is the models that doesn't have the serialize or entity annotation
 * and its from the MainViewModel
 */

class PhotosCleanModel(

    val id: Int = 0,

    var albumId: Int = 0,

    val title: String? = "",

    val url: String? = "",

    val thumbnailUrl: String? = ""
)