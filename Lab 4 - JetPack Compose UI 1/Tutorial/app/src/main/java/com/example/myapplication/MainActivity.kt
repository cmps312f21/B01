package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

@Composable
fun MyFirstComposable(name: String) {
    Column() {
        Text(text = "Welcome to JetPack Compose Mr. $name")
        Text(text = "This android studio needs some improvements")
        Text(text = "This android studio needs some improvements")
        Text(text = "This android studio needs some improvements")
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