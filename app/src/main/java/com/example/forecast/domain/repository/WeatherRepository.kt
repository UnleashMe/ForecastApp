package com.example.forecast.domain.repository

import com.example.forecast.data.network.dto.WeatherResponce

interface WeatherRepository {

    suspend fun getFiveDaysWeather(): WeatherResponce
}