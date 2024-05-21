package com.inspired.frog.presentation.theme


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WeatherCard(modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier= Modifier.fillMaxWidth().padding(10.dp)
        ) {

        }
    }
}