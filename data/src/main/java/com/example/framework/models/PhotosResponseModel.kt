package com.example.framework.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

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
) : Serializable