package com.example.framework.datasource

import com.example.framework.remote.GetDataService

interface GetRetrofitInterface {
    fun getRetrofitInstance(): GetDataService
}