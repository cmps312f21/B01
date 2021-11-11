package cmps312.lab3.backgroundprocessing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.work.*
import cmps312.lab3.backgroundprocessing.ui.theme.BackGroundProcessingTheme
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BackGroundProcessingTheme {
                // A surface container using the 'background' color from the theme
                //Todo add code here
                val context = LocalContext.current
                Surface(color = MaterialTheme.colors.background

                ) {

                    val constraints = Constraints
                        .Builder()
                        .setRequiredNetworkType(NetworkType.CONNECTED)
                        .setRequiresBatteryNotLow(true)
                        .build()

                    val oneTimeRequest = OneTimeWorkRequestBuilder<MyWork>()
                        .setConstraints(constraints)
                        .build()

                    val periodicWorkRequest = PeriodicWorkRequestBuilder<MyWork>(15, TimeUnit.MINUTES)
                        .setConstraints(constraints)
                        .build()

                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = androidx.compose.ui.Modifier.padding(40.dp))

                        Button(onClick = {
                            WorkManager.getInstance(context).enqueue(oneTimeRequest)
                        }) {
                            Text(text = "Do one time work")
                        }
                        Button(onClick = {
                            WorkManager.getInstance(context).enqueue(periodicWorkRequest)
                        }) {
                            Text(text = "Schedule Periodic work")
                        }

                        //  Text(text = jobState)

                    }

                }
            }
        }
    }
}

