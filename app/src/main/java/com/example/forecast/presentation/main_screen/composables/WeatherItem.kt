package com.example.forecast.presentation.main_screen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.example.forecast.domain.model.Weather
import com.example.forecast.presentation.common_composables.CustomCard
import com.example.forecast.ui.theme.AppTheme

@Composable
fun WeatherItem(
    weather: Weather
) {
    CustomCard(modifier = Modifier.padding(vertical = AppTheme.dimens.tiny)) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.dimens.smallMedium)
        ) {
            Text(text = weather.date, style = MaterialTheme.typography.headlineSmall)
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(IntrinsicSize.Max)
            ) {
                Column(
                    Modifier.weight(1f).fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    AsyncImage(
                        model = "https:" + weather.iconUrl,
                        contentDescription = null,
                        modifier = Modifier.size(AppTheme.dimens.large)
                    )
                    Text(text = weather.description)
                }
                Column(
                    Modifier.weight(1f).fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Temperature: ${weather.temperature}°С")
                    Text(text = "Wind: ${weather.wind} km/h")
                    Text(text = "Humidity: ${weather.humidity} %")
                }
            }
        }
    }
}