package com.example.framework.models

import com.example.core.domain.PhotosMapper
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * PhotosResponseModel it's a class that implement Serializable interface to use the gson annotations
 * and implements the ResponseEntityInterface with the PhotosEntityModel to map the object
 * and return a PhotosEntityModel
 */
class PhotosResponseModel(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("albumId")
    var albumId: Int = 0,
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String? = ""
) : Serializable, PhotosMapper<PhotosEntityModel> {

    override fun mapper(): PhotosEntityModel = PhotosEntityModel(
        id,
        albumId,
        title,
        url,
        thumbnailUrl
    )
}