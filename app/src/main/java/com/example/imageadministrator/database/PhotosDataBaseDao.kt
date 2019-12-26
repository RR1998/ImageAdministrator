package com.example.imageadministrator.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.imageadministrator.models.PhotosModel

@Dao
interface PhotosDataBaseDao {
    @Insert
    fun insert(photo: PhotosModel)

    @Query("SELECT * FROM photos LIMIT 25")
    fun getPhotos():LiveData<List<PhotosModel>>
}