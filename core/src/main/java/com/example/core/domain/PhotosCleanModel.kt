package com.example.core.domain

/**
 * CleanModel is the models that doesn't have the serialize or entity annotation
 * and its from the MainViewModel
 */
class PhotosCleanModel(

    var id: Int = 0,

    var albumId: Int = 0,

    var title: String? = "",

    var url: String? = "",

    var thumbnailUrl: String? = ""
)