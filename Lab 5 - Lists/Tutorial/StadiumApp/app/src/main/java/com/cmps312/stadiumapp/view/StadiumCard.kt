package com.cmps312.stadiumapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmps312.stadiumapp.R
import com.cmps312.stadiumapp.model.Stadium
import com.cmps312.stadiumapp.ui.theme.StadiumAppTheme

@Composable
fun StadiumCard(stadium: Stadium) {
    val context = LocalContext.current
    val imageId =  context.resources.getIdentifier(
        stadium.imageName,
        "drawable",
        context.packageName

    )

    Card(elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row() {
            Image(painter = painterResource(id = imageId) ,
                contentDescription = "Stadium For World Cup",
            modifier = Modifier.size(150.dp).padding(10.dp)
                .clip(RoundedCornerShape(10.dp)))
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(text = "Name = ${stadium.name}")
                Text(text = stadium.city)
                Text(text = stadium.status)
            }
        }
    }

}

@Preview
@Composable
fun StadiumCardPreview(){
    StadiumAppTheme {
        val stadium = Stadium(
            "Al-Kharafa",
            "Doha",
            "Completed",
            "al_gharafa")
        StadiumCard(stadium)
    }
}