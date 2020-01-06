package com.example.framework.models

/**
 * ResponseEntityInterface creates a responseToEntity function that returns an any type object
 */

interface ResponseEntityInterface<T:Any> {

    fun responseToEntity():T
}