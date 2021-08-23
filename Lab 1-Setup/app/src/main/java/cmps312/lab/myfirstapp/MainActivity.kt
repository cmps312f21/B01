package cmps312.lab.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //let us listen to button clicks
        showBtn.setOnClickListener {
            val name = nameEdt.text.toString()
            displayTv.text = "Welcome to CMPS 312 Mr.$name"
        }

    }
}