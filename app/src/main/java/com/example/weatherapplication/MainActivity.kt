package com.example.weatherapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.weatherapplication.screens.MainCard
import com.example.weatherapplication.screens.TabLayout
import com.example.weatherapplication.ui.theme.WeatherApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherApplicationTheme {
                Image(painter = painterResource(id = R.drawable.weather), contentDescription = null, modifier = Modifier
                    .fillMaxSize()
                    .alpha(1f), contentScale = ContentScale.FillBounds)
                Column() {
                    MainCard()
                    TabLayout()
                }
            }
        }
    }
}
