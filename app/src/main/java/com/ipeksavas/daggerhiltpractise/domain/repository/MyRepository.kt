package com.ipeksavas.daggerhiltpractise.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()
}