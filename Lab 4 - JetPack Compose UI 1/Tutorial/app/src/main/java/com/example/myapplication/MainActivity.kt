package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun MyFirstComposable(name: String , age: Int = 55, gender : String = "Male") {
    Row() {
        Text(text = "Name Mr. $name")
        Text(text = "Gender : $gender")
        Text(text = "Age : $age")
    }
    
    Column() {
        Text(text = "Image")
        Column() {
            Text(text = "Name of person")
            Text(text = "Icon")
            Row() {
                
            }
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