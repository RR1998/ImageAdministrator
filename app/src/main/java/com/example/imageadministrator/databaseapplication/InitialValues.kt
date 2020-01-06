package com.example.imageadministrator.databaseapplication

import android.app.Application
import com.example.core.interactors.GetPhotos
import com.example.framework.database.PhotosGetDatabase
import com.example.framework.datasource.ModelSourceRepositoryImplementation
import com.example.framework.remote.PhotosApi

class InitialValues : Application() {


    lateinit var database: PhotosGetDatabase
    lateinit var useCase: GetPhotos

    override fun onCreate() {
        super.onCreate()
        database = PhotosGetDatabase.getInstance(applicationContext)
        val api = PhotosApi
        val repository = ModelSourceRepositoryImplementation(api, database)
        useCase = GetPhotos(repository)
    }
}