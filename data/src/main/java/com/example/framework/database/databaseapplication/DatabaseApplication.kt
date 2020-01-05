package com.example.framework.database.databaseapplication

import android.app.Application
import com.example.framework.database.PhotosGetDatabase
import com.example.framework.models.PhotosResponseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext

class DatabaseApplication : Application() {

    private var classDatabaseInstance: Class<out PhotosGetDatabase> =
        PhotosGetDatabase.getInstance(this)::class.java

    lateinit var database: PhotosGetDatabase

    private var databaseApplicationJob = Job()

    var uiScope = CoroutineScope(Dispatchers.Main + databaseApplicationJob)

    override fun onCreate() {
        super.onCreate()
        database = classDatabaseInstance.newInstance()
    }

    suspend fun savePhotos(cleanList: List<PhotosResponseModel>?) {
        withContext(Dispatchers.IO) {
            cleanList?.forEach {
                database.daoInterface().insert(it.responseEntity())
            }
        }
    }
}