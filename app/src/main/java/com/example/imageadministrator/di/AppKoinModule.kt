@file:Suppress("SpellCheckingInspection", "SpellCheckingInspection")

package com.example.imageadministrator.di

import com.example.core.interactors.GetPhotos
import com.example.core.repository.PhotosDataSourceRepository
import com.example.framework.database.PhotosGetDatabase
import com.example.framework.datasource.ModelSourceRepositoryImplementation
import com.example.framework.remote.PhotosApi
import com.example.imageadministrator.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Koin module definition
 */

/**
 * appModule is where're declared the app injection as the viewModel
 */
val appModule = module {

    viewModel { MainViewModel(get()) }
}

/**
 * coreModule is where're declared the core injection as the GetPhotos
 */
val coreModule = module {

    single { GetPhotos(get()) }
}

/**
 * dataModule is where're declared the data injection as the
 */
val dataModule = module {

    single<PhotosDataSourceRepository> { ModelSourceRepositoryImplementation(get(), get()) }

    single { PhotosApi.getRetrofitInstance() }

    single { PhotosGetDatabase.getInstance(androidContext()) }

    single { (get() as PhotosGetDatabase).daoInterface() }
}
