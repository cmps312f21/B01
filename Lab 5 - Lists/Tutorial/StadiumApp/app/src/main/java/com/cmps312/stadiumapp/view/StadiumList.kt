package com.cmps312.stadiumapp.view

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.cmps312.stadiumapp.model.Stadium
import com.cmps312.stadiumapp.model.StadiumRepository
import com.cmps312.stadiumapp.ui.theme.StadiumAppTheme

@Composable
fun StadiumList(context : Context) {
    val stadiums = StadiumRepository.getStadiums(context)

    Column() {
        LazyColumn() { items(stadiums) { StadiumCard(it) } }
    }
}

@Preview
@Composable
fun TestMyStadiumComposable(){
    StadiumAppTheme {
        StadiumList(LocalContext.current)
    }
}