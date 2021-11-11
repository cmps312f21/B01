package cmps312.lab3.backgroundprocessing

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

//Backing up data
class MyWork(appContext: Context, params: WorkerParameters) : CoroutineWorker(appContext, params) {
    val TAG = "My Worker"
    override suspend fun doWork(): Result = coroutineScope {
        aLongRunningTask()
        Result.success()
    }

    //simulate
    suspend fun aLongRunningTask() {
        //get data from server and save into the room database
        //live data -> my UI will update
        Log.d(TAG, "aLongRunningTask started")
        delay(1000 * 10)
        Log.d(TAG, "aLongRunningTask Done ")
    }
}
