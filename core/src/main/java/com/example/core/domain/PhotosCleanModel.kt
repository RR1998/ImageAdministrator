package com.example.core.domain

import android.os.Parcel
import android.os.Parcelable


class PhotosCleanModel(

    val id: Int = 0,

    var albumId: Int = 0,

    val title: String? = "",

    val url: String? = "",

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
        parcel.writeInt(id)
        parcel.writeInt(albumId)
        parcel.writeString(title)
        parcel.writeString(url)
        parcel.writeString(thumbnailUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PhotosCleanModel> {
        override fun createFromParcel(parcel: Parcel): PhotosCleanModel {
            return PhotosCleanModel(parcel)
        }

        override fun newArray(size: Int): Array<PhotosCleanModel?> {
            return arrayOfNulls(size)
        }
    }
}