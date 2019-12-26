package com.example.imageadministrator.models

import android.os.Parcel
import android.os.Parcelable

data class PhotosModel(

    val albumId: Int,
    val id: Int,
    val title: String?,
    val url: String?,
    val thumbnailUrl: String?
): Parcelable {

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