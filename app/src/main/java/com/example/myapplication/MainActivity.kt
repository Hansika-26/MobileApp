package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Delay in milliseconds (e.g., 3000ms = 3 seconds)
        val delayMillis = 3000L

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Screen01Activity::class.java)
            startActivity(intent)
            finish() // Optional: Finish MainActivity so the user can't navigate back
        }, delayMillis)
    }
}