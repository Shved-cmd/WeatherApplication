package com.example.weatherapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapplication.R
import com.example.weatherapplication.ui.theme.BlueLight

@Preview(showBackground = true)
@Composable
fun MainScreen() {
    Image(painter = painterResource(id = R.drawable.weather), contentDescription = null, modifier = Modifier
        .fillMaxSize()
        .alpha(1f), contentScale = ContentScale.FillBounds)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    

    ) {
        Card(modifier = Modifier.fillMaxWidth(), backgroundColor = BlueLight, elevation = 3.dp, shape = RoundedCornerShape(10.dp))  {
                        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                Text(text = "20 jun 2022 13:00", style = TextStyle(fontSize = 15.sp), color = Color.White, modifier = Modifier.padding(top = 10.dp, start = 10.dp))
                                AsyncImage(modifier = Modifier
                                    .size(35.dp)
                                    ,model = "https://cdn.weatherapi.com/weather/64x64/night/122.png", contentDescription = null) // Получаем текующую иконку "погоды" из Лондона по ссылке
                            }
                            Text(text = "Madrid", style = TextStyle(fontSize = 24.sp), color = Color.White)
                            Text(text = "23°C", style = TextStyle(fontSize = 24.sp), color = Color.White)
                            Text(text = "Madrid", style = TextStyle(fontSize = 24.sp), color = Color.White)

                            Row() {

                            }
                        }
        }
    }
}