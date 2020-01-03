package com.example.framework.datasource

import com.example.framework.remote.GetDataService

interface RetrofitInstance {
    fun getRetrofitInstance(): GetDataService
}