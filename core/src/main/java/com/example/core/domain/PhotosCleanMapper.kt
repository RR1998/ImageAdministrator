package com.example.core.domain

interface PhotosCleanMapper<T:Any> {
    fun cleaner():T
}