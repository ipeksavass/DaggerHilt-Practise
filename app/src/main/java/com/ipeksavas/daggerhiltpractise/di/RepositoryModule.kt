package com.ipeksavas.daggerhiltpractise.di

import com.ipeksavas.daggerhiltpractise.data.repository.MyRepositoryImpl
import com.ipeksavas.daggerhiltpractise.domain.repository.MyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    
    @Binds
    @Singleton
    abstract fun bindsMyRepository(
        myRepositoryImpl: MyRepositoryImpl
    ): MyRepository
}
/*
    Ben sana nesneyi elle üretip vermeyeceğim (return MyRepositoryImpl(...) yok).
    Sen git MyRepositoryImpl sınıfını kendin üret, sonra da onu MyRepository interface'ine bağla.
    Hilt'in MyRepositoryImpl'i kendi kendine üretebilmesi için o sınıfın kurucusunun (constructor) başında @Inject olması şarttır.
    
 */