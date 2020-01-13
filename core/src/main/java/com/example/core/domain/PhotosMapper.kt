package com.example.core.domain

/**
 * PhotosCleanMapper creates an interfaces that returns an any type object its used to convert
 * from a model of any type to clean model
 */
interface PhotosMapper<T : Any> {

    fun mapper(): T
}