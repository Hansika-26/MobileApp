package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Location : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_location)

        val backArrow = findViewById<ImageView>(R.id.back_Arrow)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)  // Get the Submit button

        // Navigate back to Cart page
        backArrow.setOnClickListener {
            navigateBackToCartPage()
        }

        // Navigate to Home page when Submit button is clicked
        buttonSubmit.setOnClickListener {
            navigateToLastPage()
        }
    }

    private fun navigateBackToCartPage() {
        val intent = Intent(this, Cart::class.java)  // Replace with your Cart activity
        startActivity(intent)
    }

    private fun navigateToLastPage() {
        val intent = Intent(this, ThankActivity::class.java)
        startActivity(intent)
    }
}
