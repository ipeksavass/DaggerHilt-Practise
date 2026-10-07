package com.ipeksavas.daggerhiltpractise.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
/*
Bu modülün içindeki nesneler uygulama ilk açıldığında yaşasın, uygulama arka planda tamamen kapatılana kadar
hayatta kalsın ve uygulamanın içindeki her yerden (her Activity, Fragment, ViewModel) erişilebilsin.

@InstallIn(SingletonComponent::class), ilgili Hilt modülünün içerdiği bağımlılıkları doğrudan
uygulamanın ana yaşam döngüsüne (Application Lifecycle) bağlar;
böylece sağlanan nesnelerin uygulamanın ayağa kalktığı andan süreç sonlanana kadar hafızada
tekil (Singleton) olarak yaşamasını ve tüm uygulama katmanlarından erişilebilir olmasını garanti eder.
 */
object AppModule {
}