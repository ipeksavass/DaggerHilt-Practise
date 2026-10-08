package com.ipeksavas.daggerhiltpractise

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp: Application()
/*
    Hilt kullancak uygulama seviyesinde bağımlılık enjeksiyonu yapabilmek için Application sınıfını extend eden bir sınıf oluşturup
    bu sınıfı @HiltAndroidApp ile işaretlememiz gerekiyor. Ve gidip bunu AndroidManifest.xml içine eklersin:
    <application
    android:name=".MyApp"

 */