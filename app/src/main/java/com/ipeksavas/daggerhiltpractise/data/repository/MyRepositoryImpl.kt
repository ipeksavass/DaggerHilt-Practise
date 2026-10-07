package com.ipeksavas.daggerhiltpractise.data.repository

import com.ipeksavas.daggerhiltpractise.data.remote.MyApi
import com.ipeksavas.daggerhiltpractise.domain.repository.MyRepository

class MyRepositoryImpl(
    private val api: MyApi
): MyRepository {
    override suspend fun doNetworkCall() {
        TODO("Not yet implemented")
    }
}