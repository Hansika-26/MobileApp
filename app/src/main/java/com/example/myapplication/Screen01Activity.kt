package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Screen01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen01)

        // Find the Next button by its ID
        val loginButton: Button = findViewById(R.id.Next1)

        loginButton.setOnClickListener {
            // Create an Intent to navigate to the Home activity
            val intent = Intent(this, Screen02Activity::class.java)
            startActivity(intent)
        }


    }
}
