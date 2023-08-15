package com.example.forecast.presentation.main_screen

import com.example.forecast.domain.model.Weather

data class MainScreenState(
    val isLoading: Boolean = false,
    val error: String = "",
    val weather: List<Weather>? = listOf()
)
