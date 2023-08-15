package com.example.forecast.presentation.main_screen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.forecast.presentation.common_composables.ErrorScreen
import com.example.forecast.presentation.common_composables.LoadingScreen
import com.example.forecast.presentation.main_screen.MainScreenViewModel
import com.example.forecast.ui.theme.AppTheme

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    state.weather?.let { weather ->
        LazyColumn(
            modifier = Modifier.background(MaterialTheme.colorScheme.background).padding(AppTheme.dimens.smallMedium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "Saint-Petersburg, 5 days weather forecast",
                    style = MaterialTheme.typography.displaySmall,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            items(weather) {
                WeatherItem(weather = it)
            }
        }
    }
    if (state.isLoading) {
        LoadingScreen()
    }
    if (state.error.isNotEmpty()) {
        ErrorScreen(errorMessage = state.error) {
            viewModel.getWeather()
        }
    }
}