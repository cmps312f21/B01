package com.cmps312.calculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmps312.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

//state hoisting
@Composable
fun MyApp() {
    var total by remember { mutableStateOf(0) }


    Column() {
        MyCalculatorScreen(total, updateTotal = { newTotal -> total = newTotal })
        MyCalculatorScreen(total, updateTotal = { newTotal -> total = newTotal })

        Text(
            text = "Increment Total by 1 $total",
            modifier = Modifier.clickable {
                total++
                Log.d("Counter", "Counted $total")
            })
    }
}

@Composable
fun MyCalculatorScreen(
    total: Int,
    updateTotal: (Int) -> Unit,

) {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.Red)
    ) {
        Column() {

            TextField(value = number1, onValueChange = { number1 = it })
            Spacer(modifier = Modifier.height(5.dp))
            TextField(value = number2, onValueChange = { number2 = it })
            Text(text = "$total")

            if (number1.isNotEmpty() and number2.isNotEmpty())
                updateTotal(number1.toInt() + number2.toInt())

            Spacer(modifier = Modifier.height(5.dp))

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorTheme {
        MyApp()
    }
}