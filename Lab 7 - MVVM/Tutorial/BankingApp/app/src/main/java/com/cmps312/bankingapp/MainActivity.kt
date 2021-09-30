package com.cmps312.bankingapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cmps312.bankingapp.ui.theme.BankingAppTheme
import com.cmps312.bankingapp.view.TransferList
import com.cmps312.bankingapp.viewmodel.BankingViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(this)
                }
            }
        }
    }
}

@Composable
fun Greeting(context: Context) {
    val bankingViewModel =
        viewModel<BankingViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)

    TransferList(onTransferItemSelected = {
        Toast.makeText(context,
            "Selected a transfer ${bankingViewModel.selectedTransfer}", Toast.LENGTH_SHORT).show()
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BankingAppTheme {

    }
}