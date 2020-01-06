package com.example.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.framework.models.PhotosEntityModel

/**
 * PhotosGetDatabase implements the RoomDatabase class and creates an instances from it
 */

@Database(entities = [PhotosEntityModel::class], version = 1, exportSchema = false)
abstract class PhotosGetDatabase : RoomDatabase() {

    abstract fun daoInterface(): PhotosDataBaseDao

    companion object {

        @Volatile
        private var INSTANCE: PhotosGetDatabase? = null

        fun getInstance(context: Context): PhotosGetDatabase {

            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {

                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PhotosGetDatabase::class.java,
                        "photos_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance

                }

                return instance
            }
        }
    }
}