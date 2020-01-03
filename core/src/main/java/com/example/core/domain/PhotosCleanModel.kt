package com.example.core.domain


class PhotosCleanModel (

    val id: Int = 0,

    var albumId: Int = 0,

    val title: String? = "",

    val url: String? = "",

    val thumbnailUrl: String? = ""
):PhotosCleanMapper{
    override fun cleaner(
        id: Int,
        albumId: Int,
        title: String,
        url: String,
        thumbnailUrl: String
    ): PhotosCleanModel
        = PhotosCleanModel(id = id, albumId = albumId, title = title, url = url, thumbnailUrl = thumbnailUrl)
}