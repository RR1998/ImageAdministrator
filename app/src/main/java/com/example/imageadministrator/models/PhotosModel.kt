package com.example.imageadministrator.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "photos")
data class PhotosModel(

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

) : Parcelable {

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

    companion object CREATOR : Parcelable.Creator<PhotosModel> {

        override fun createFromParcel(parcel: Parcel): PhotosModel {
            return PhotosModel(parcel)
        }

        override fun newArray(size: Int): Array<PhotosModel?> {
            return arrayOfNulls(size)
        }
    }
}