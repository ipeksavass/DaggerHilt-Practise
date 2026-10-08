package com.ipeksavas.daggerhiltpractise.di

import android.app.Application
import com.ipeksavas.daggerhiltpractise.data.remote.MyApi
import com.ipeksavas.daggerhiltpractise.data.repository.MyRepositoryImpl
import com.ipeksavas.daggerhiltpractise.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

//app module'deki bağımlılıklarımızın ömrünü belirler. Tüm bu bağımlılıklar uygulama boyunca yaşayacaktır.
/*
Bu modülün içindeki nesneler uygulama ilk açıldığında yaşasın, uygulama arka planda tamamen kapatılana kadar
hayatta kalsın ve uygulamanın içindeki her yerden (her Activity, Fragment, ViewModel) erişilebilsin.

@InstallIn(SingletonComponent::class), ilgili Hilt modülünün içerdiği bağımlılıkları doğrudan
uygulamanın ana yaşam döngüsüne (Application Lifecycle) bağlar;
böylece sağlanan nesnelerin uygulamanın ayağa kalktığı andan süreç sonlanana kadar hafızada
tekil (Singleton) olarak yaşamasını ve tüm uygulama katmanlarından erişilebilir olmasını garanti eder.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    //boilerplate
    @Provides
    @Singleton//Bileşen başına bir kez oluşturulacak ve tüm uygulama boyunca aynı örnek kullanılacak.
    fun provideMyApi(): MyApi{
        return Retrofit.Builder()
            .baseUrl("http://test.com")
            .build()
            .create(MyApi::class.java)
        //MyApi arayüzünü somut bir nesneye dönüştürmek için Retrofit kullanıyoruz.
        // Retrofit, HTTP isteklerini yönetmek ve yanıtları almak için kullanılan bir kütüphanedir.
        // Bu sayede MyApi arayüzündeki tanımlı HTTP çağrılarını gerçekleştirebiliriz.
    }
    
    @Provides
    @Singleton
    fun provideMyRepository(api: MyApi,app: Application): MyRepository{
        return MyRepositoryImpl(api,app)
    }
}