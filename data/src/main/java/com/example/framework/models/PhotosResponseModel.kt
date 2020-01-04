package com.example.framework.models

import android.os.Parcel
import android.os.Parcelable
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
) : Serializable, ResponseEntityInterface<PhotosEntityModel>, Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun responseEntity(): PhotosEntityModel =
        PhotosEntityModel(id, albumId, title, url, thumbnailUrl)

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

    companion object CREATOR : Parcelable.Creator<PhotosResponseModel> {
        override fun createFromParcel(parcel: Parcel): PhotosResponseModel {
            return PhotosResponseModel(parcel)
        }

        override fun newArray(size: Int): Array<PhotosResponseModel?> {
            return arrayOfNulls(size)
        }
    }
}