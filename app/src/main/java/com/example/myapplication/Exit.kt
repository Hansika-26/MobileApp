package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Exit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_exit)


        // Find the Yes button by its ID
        val Button: Button = findViewById(R.id.buttonYes)

        Button.setOnClickListener {
            // Create an Intent to navigate to the Home activity
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        // Find the Yes button by its ID
        val ButtonN: Button = findViewById(R.id.buttonNo)

        ButtonN.setOnClickListener {
            // Create an Intent to navigate to the Home activity
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }


    }
}