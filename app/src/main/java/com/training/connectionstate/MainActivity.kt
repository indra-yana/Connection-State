package com.training.connectionstate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ConnectionState(applicationContext).apply {
            observe(this@MainActivity, Observer { isConnected ->
                if (isConnected) {
                    layoutConnected.visibility = View.VISIBLE
                    layoutDisconnected.visibility = View.GONE
                } else {
                    layoutConnected.visibility = View.GONE
                    layoutDisconnected.visibility = View.VISIBLE
                }
            })
        }
    }
}
