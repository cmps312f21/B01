package com.cmps312.myapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmps312.myapplication.views.StadiumList
import com.cmps312.myapplication.repository.StadiumRepo
import com.cmps312.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyApp(this)
                }
            }
        }
    }
}

@Composable
fun MyApp(context: Context) {
    Scaffold(
        topBar = { TopBar() },
        content = { StadiumList(StadiumRepo.getStadiums(context)) }
    )
}

@Composable
fun TopBar() {
    Column(modifier = Modifier
        .background(MaterialTheme.colors.primary)
        .fillMaxWidth()) {
        Text(text = "This is the top bar",
            modifier = Modifier.height(40.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MyApp(LocalContext.current)
    }
}