package com.example.framework.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.framework.models.PhotosEntityModel

/**
 * PhotosDatabaseDao implements the insert and query annotations that creates the respective query
 */

@Dao
interface PhotosDataBaseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(photo: PhotosEntityModel)

    @Query("SELECT * FROM photos LIMIT 25")
    fun getPhotos(): List<PhotosEntityModel>
}