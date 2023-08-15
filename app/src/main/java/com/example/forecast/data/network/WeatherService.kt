package com.example.forecast.data.network

import com.example.forecast.data.network.dto.WeatherResponce
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {

    @GET("{path}")
    suspend fun getFiveDaysWeather(
        @Path("path") path:String = "forecast.json",
        @Query("q") cityName: String = "saint-petersburg",
        @Query("days") days: String = "5",
        @Query("key") appId: String = "360c4ba1bab0485ca7e114852231408"
    ): WeatherResponce

}