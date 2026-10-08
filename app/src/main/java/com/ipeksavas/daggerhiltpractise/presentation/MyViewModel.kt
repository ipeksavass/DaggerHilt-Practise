package com.ipeksavas.daggerhiltpractise.presentation

import androidx.lifecycle.ViewModel
import com.ipeksavas.daggerhiltpractise.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
): ViewModel() {

}