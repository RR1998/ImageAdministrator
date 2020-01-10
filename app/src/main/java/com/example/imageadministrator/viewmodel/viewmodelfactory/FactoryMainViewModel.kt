package com.example.imageadministrator.viewmodel.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.interactors.GetPhotos
import com.example.imageadministrator.viewmodel.MainViewModel

/**
 * FactoryMainViewModel its used to create MainViewModels
 */
@Suppress("UNCHECKED_CAST")
class FactoryMainViewModel(private val useCase: GetPhotos): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(useCase) as T
    }
}