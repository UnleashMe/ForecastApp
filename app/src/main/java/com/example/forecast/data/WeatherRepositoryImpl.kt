package com.example.forecast.data

import com.example.forecast.data.network.WeatherService
import com.example.forecast.data.network.dto.WeatherResponce
import com.example.forecast.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherService: WeatherService):
    WeatherRepository {

    override suspend fun getFiveDaysWeather(): WeatherResponce {
        return weatherService.getFiveDaysWeather()
    }
}