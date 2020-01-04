package com.example.framework.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.domain.PhotosCleanMapper
import com.example.core.domain.PhotosCleanModel


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

) : Parcelable, PhotosCleanMapper<PhotosCleanModel> {

    constructor(parcel: Parcel) : this(

        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()

    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(albumId)
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(url)
        parcel.writeString(thumbnailUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PhotosEntityModel> {

        override fun createFromParcel(parcel: Parcel): PhotosEntityModel {
            return PhotosEntityModel(parcel)
        }

        override fun newArray(size: Int): Array<PhotosEntityModel?> {
            return arrayOfNulls(size)
        }
    }

    override fun cleaner(): PhotosCleanModel = PhotosCleanModel(
        id,
        albumId,
        title,
        url,
        thumbnailUrl
    )
}