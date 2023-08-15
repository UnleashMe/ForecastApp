package com.example.forecast.presentation.common_composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.forecast.ui.theme.AppTheme

@Composable
fun ErrorScreen(
    errorMessage: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Something went wrong!",
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(bottom = AppTheme.dimens.medium),
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = AppTheme.dimens.medium),
                color = MaterialTheme.colorScheme.onBackground
            )
            Button(
                onClick = { onClick() },
                shape = RoundedCornerShape(AppTheme.dimens.medium),
                border = BorderStroke(AppTheme.dimens.tiny, MaterialTheme.colorScheme.secondary),
                colors = ButtonDefaults.buttonColors(contentColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Text(
                    text = "Try again",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}