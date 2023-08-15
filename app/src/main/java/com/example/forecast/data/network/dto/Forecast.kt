package com.example.forecast.data.network.dto

data class Forecast(
    val forecastday: List<Forecastday> = listOf()
)