package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MyFirstComposable(name = "Abdulahi Hassen")
            }
        }
    }
}

//Modifiers
@Composable
fun MyFirstComposable(name: String, age: Int = 36, gender: String = "Male") {
    Row() {
        Image(painter = painterResource(id = R.drawable.ronaldo),
            contentDescription = "Ronaldo",
            modifier = Modifier.size(80.dp)
            )
        Column() {
            Text(text = "Name : $name")
            Text(text = "Age : $age")
            Text(text = "Gender : $gender")
        }
    }
}

@Preview
@Composable
fun DisplayPreview() {
    MyApplicationTheme {
        MyFirstComposable(name = "Abdulahi Hassen")
    }
}


//Layouts