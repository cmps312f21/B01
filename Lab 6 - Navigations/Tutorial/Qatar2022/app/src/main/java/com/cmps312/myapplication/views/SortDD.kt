package com.cmps312.myapplication.views

import androidx.compose.runtime.Composable
import com.cmps312.myapplication.repository.SortByOptions

enum
@Composable
fun SortDD(){
   var sortOptions = listOf(
      SortByOptions.NONE,
      SortByOptions.CITY_NAME,
      SortByOptions.SEATING_CAPACITY,
      SortByOptions.STADIUM_NAME)
}