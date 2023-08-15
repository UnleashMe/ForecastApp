package com.example.forecast.data.network.dto

import com.example.forecast.domain.model.Weather

data class Forecastday(
    val astro: Astro = Astro(),
    val date: String = "",
    val date_epoch: Int = 0,
    val day: Day = Day(),
    val hour: List<Hour> = listOf()
) {
    fun toWeather(): Weather {
        return Weather(
            date = date,
            description = this.day.condition.text,
            iconUrl = this.day.condition.icon,
            temperature = this.day.avgtemp_c,
            wind = this.day.maxwind_kph,
            humidity = this.day.avghumidity
        )
    }
}