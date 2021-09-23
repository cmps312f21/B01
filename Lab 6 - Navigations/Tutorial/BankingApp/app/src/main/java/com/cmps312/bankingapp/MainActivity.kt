package com.cmps312.bankingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cmps312.bankingapp.ui.theme.BankingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navHostController = rememberNavController()
    Scaffold(
        topBar = {TopBar(navHostController)},
        bottomBar = {BottomBar(navHostController)}
    ) 
}


@Composable
fun TopBar(navHostController: NavHostController) {

}

@Composable
fun BottomBar(navHostController: NavHostController) {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BankingAppTheme {
        MyApp()
    }
}