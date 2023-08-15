package com.example.forecast.domain.use_cases

import com.example.forecast.domain.model.Weather
import com.example.forecast.domain.repository.WeatherRepository
import com.example.weather.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetForecastWeatherUseCase @Inject constructor(private val repository: WeatherRepository) {

    operator fun invoke(): Flow<Resource<List<Weather>>> = flow {
        try {
            emit(Resource.Loading())
            val weather = repository.getFiveDaysWeather()
            emit(Resource.Success(weather.forecast.forecastday.map { it.toWeather() }))
        } catch (e: HttpException) {
            emit(Resource.Error("HttpException"))
        } catch (e: IOException) {
            emit(Resource.Error("Check your connection"))
        }
    }
}