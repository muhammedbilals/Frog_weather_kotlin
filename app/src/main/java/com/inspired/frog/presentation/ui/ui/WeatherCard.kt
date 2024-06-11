package com.inspired.frog.presentation.ui.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inspired.frog.R
import com.inspired.frog.presentation.WeatherState
import androidx.compose.ui.graphics.painter.Painter as Painter1


@Composable

fun WeatherCard(
    state:WeatherState,
    modifier: Modifier = Modifier,
                backgroundColor:Color
) {

        Column(
            modifier= Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally


        ) {
            Spacer(modifier = Modifier.height(30.dp))

            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "image", modifier = Modifier.width(200.dp).height(200.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Sunny",
                fontSize = 10.sp,
                color = Color.White

                )
        }

}