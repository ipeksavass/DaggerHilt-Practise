package com.ipeksavas.daggerhiltpractise.presentation

import androidx.lifecycle.ViewModel
import com.ipeksavas.daggerhiltpractise.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import dagger.Lazy

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: Lazy<MyRepository>
): ViewModel() {
    
    init{
        repository.get()
    }
}

/*
    Lazy<MyRepository> yaparsan Hilt nesneyi baştan üretmez; ancak ve ancak kodun bir yerinde repository.get() dediğin an üretir.
    Uygulamanın ilk açılışını hızlandırmak ve gereksiz nesne yaratımını engellemek için kullanılır.
 */