package com.example.myapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MyApp() }
    }
}
@Composable
fun MyApp() {
    MyApplicationTheme {


        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
//                verticalArrangement = Arrangement.SpaceEvenly,
//                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Text(text = stringResource(id = R.string.app_name))
                Surface(
                    modifier = Modifier
                        .weight(1f)  //dynamic resizing
                        .width(100.dp)
                        .height(400.dp),
                    color = Color.Red
                ) {}
                Surface(
                    modifier = Modifier
//                        .weight(10f)
                        .width(100.dp)
                        .height(400.dp),
                    color = Color.Black
                ) {}
            }
        }
    }
}

//Modifiers
@Composable
fun MyFirstComposable(name: String = "Ali", age: Int = 36, gender: String = "Male") {

    Column() {

    }

//    Row(modifier = Modifier.background(Color.Cyan).width(200.dp)) {
//        Image(
//            painter = painterResource(id = R.drawable.ronaldo),
//            contentDescription = "Ronaldo",
//            modifier = Modifier
//                .size(90.dp)
//                .clip(CircleShape)
//                .border(
//                    1.25.dp, MaterialTheme
//                        .colors.secondary, CircleShape
//                )
//        )
////        Spacer(modifier = Modifier.width(10.dp))
//        Column(modifier = Modifier.padding(10.dp)) {
//            Text(
//                text = "Name : $name",
//                fontWeight = FontWeight.Bold,
//                fontStyle = FontStyle.Italic,
//                color = Color.Red,
//                modifier = Modifier.width(100.dp)
////                    .background(Color.Magenta)
//            )
//            Divider(color = Color.Black)
//            Text(text = "Age : $age")
//            Text(text = "Gender : $gender")
//        }
//    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun DisplayPreview() {
    MyApp()
}