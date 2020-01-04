package com.example.framework.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.framework.models.PhotosEntityModel

@Dao
interface PhotosDataBaseDao {

    @Insert
    fun insert(photo: PhotosEntityModel)

    @Query("SELECT * FROM photos LIMIT 25")
    fun getPhotos(): List<PhotosEntityModel>
}