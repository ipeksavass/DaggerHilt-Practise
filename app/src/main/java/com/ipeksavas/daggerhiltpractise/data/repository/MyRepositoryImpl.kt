package com.ipeksavas.daggerhiltpractise.data.repository

import android.app.Application
import com.ipeksavas.daggerhiltpractise.R
import com.ipeksavas.daggerhiltpractise.data.remote.MyApi
import com.ipeksavas.daggerhiltpractise.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: MyApi,
    private val appContext: Application
): MyRepository {
    
    init{
        val appName=appContext.getString(R.string.app_name)
        println("Hello from MyRepositoryImpl, app name is: $appName")
    }
    
    override suspend fun doNetworkCall() {
    }
}