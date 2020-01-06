package com.example.framework.datasource

import com.example.framework.remote.GetDataService

/**
 * GetRetrofitInterface it's and interface that creates the getRetroFitInstances that returns
 * a retrofit instance
 */

interface GetRetrofitInterface {
    fun getRetrofitInstance(): GetDataService
}