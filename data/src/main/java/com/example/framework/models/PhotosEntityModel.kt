package com.example.framework.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.domain.PhotosMapper
import com.example.core.domain.PhotosCleanModel

/**
 * PhotosEntityModel it's a data class that uses annotations from Room and creates a table from it
 * also implements the PhotosCleanMapper to return from an entity type object to a PhotosCleanModel
 */

@Entity(tableName = "photos")
data class PhotosEntityModel(

    @PrimaryKey
    @ColumnInfo(name = "photo_id")
    val id: Int = 0,

    @ColumnInfo(name = "album_id")
    var albumId: Int = 0,

    @ColumnInfo(name = "photo_title")
    val title: String? = "",

    @ColumnInfo(name = "photo_url")
    val url: String? = "",

    @ColumnInfo(name = "photo_thumbnail_url")
    val thumbnailUrl: String? = ""

) : PhotosMapper<PhotosCleanModel> {

    override fun mapper(): PhotosCleanModel = PhotosCleanModel(
        id,
        albumId,
        title,
        url,
        thumbnailUrl
    )
}