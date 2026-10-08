package com.ipeksavas.daggerhiltpractise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.ipeksavas.daggerhiltpractise.presentation.MyViewModel
import com.ipeksavas.daggerhiltpractise.ui.theme.DaggerHiltPractiseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DaggerHiltPractiseTheme {
                val viewModel  = hiltViewModel<MyViewModel>()
            }
        }
    }
}
