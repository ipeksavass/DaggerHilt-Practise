package com.ipeksavas.daggerhiltpractise

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.ipeksavas.daggerhiltpractise.domain.repository.MyRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyService: Service() {
    
    @Inject
    lateinit var repository: MyRepository
    
    override fun onBind(intent: Intent?): IBinder? {
        return  null
    }
}
/*
    Hilt'in Service sınıfını enjekte edebilmesi için o sınıfın başında @AndroidEntryPoint olması şarttır.
    Servislere constructor verilmez. "@Inject constructor(...)" yoktur.
    
 */