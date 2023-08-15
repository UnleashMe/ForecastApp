package com.example.forecast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.forecast.presentation.main_screen.composables.MainScreen
import com.example.forecast.ui.theme.WeatherTheme
import com.example.forecast.ui.theme.rememberWindowSizeClass
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val window = rememberWindowSizeClass()
            WeatherTheme(window) {
                MainScreen()
            }
        }
    }
}