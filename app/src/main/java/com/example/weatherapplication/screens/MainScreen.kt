package com.example.weatherapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.tiles.material.Text
import coil.compose.AsyncImage
import com.example.weatherapplication.R
import com.example.weatherapplication.ui.theme.BlueLight
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun MainCard() {


    Column(
        modifier = Modifier
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
                            Text(text = "London", style = TextStyle(fontSize = 24.sp), color = Color.White)
                            Text(text = "23°C", style = TextStyle(fontSize = 65.sp), color = Color.White)
                            Text(text = "Parly Cloudi ", style = TextStyle(fontSize = 18.sp), color = Color.White)

                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(painter = painterResource(id = R.drawable.search), contentDescription = null, tint = Color.White)
                                }
                                Text(text = "23°C/28°C", style = TextStyle(fontSize = 10.sp), color = Color.White,)
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(painter = painterResource(id = R.drawable.baseline_cloud_sync_24), contentDescription = null, tint = Color.White)
                                }

                            }
                        }
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout() {
    val tabList = listOf("HOURS", "DAYS")
    // Save states
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope() // Корутина для запуска анимации

    Column(modifier = Modifier
        .padding(start = 5.dp, end = 5.dp)
        .clip(shape = RoundedCornerShape(5.dp))) {

        TabRow(selectedTabIndex = tabIndex, indicator = {position -> TabRowDefaults.Indicator(Modifier.pagerTabIndicatorOffset(pagerState, position))}, backgroundColor = BlueLight, contentColor = Color.White ) {

            tabList.forEachIndexed{
                index, text -> Tab(selected = false, onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } }, text = {Text(text = text)})

            }

        }
        HorizontalPager(count = tabList.size, state = pagerState, modifier = Modifier.weight(1.0f)) {
            index ->
        }
    }
}

