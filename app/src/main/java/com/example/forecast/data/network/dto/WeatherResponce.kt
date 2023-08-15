package com.example.forecast.data.network.dto

data class WeatherResponce(
    val current: Current = Current(),
    val forecast: Forecast = Forecast(),
    val location: Location = Location()
)