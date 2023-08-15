package com.example.forecast.domain.model

data class Weather(
    val date: String = "",
    val description: String = "",
    val iconUrl: String = "",
    val temperature: Double = 0.0,
    val wind: Double = 0.0,
    val humidity: Double = 0.0
)