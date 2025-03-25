package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // Get references to EditTexts
        val nameEditText: EditText = findViewById(R.id.editTextText)
        val passwordEditText: EditText = findViewById(R.id.editTextTextPassword2)
        val loginButton: Button = findViewById(R.id.Login_Button)

        // Retrieve registered details from SharedPreferences
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val registeredName = sharedPreferences.getString("name", null)
        val registeredPassword = sharedPreferences.getString("password", null)

        loginButton.setOnClickListener {
            val enteredName = nameEditText.text.toString().trim()
            val enteredPassword = passwordEditText.text.toString().trim()

            if (validateInput(enteredName, enteredPassword, registeredName, registeredPassword)) {
                // If validation passes, navigate to Home
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    // Function to validate name and password
    private fun validateInput(
        enteredName: String,
        enteredPassword: String,
        registeredName: String?,
        registeredPassword: String?
    ): Boolean {
        var isValid = true

        if (enteredName.isEmpty()) {
            findViewById<EditText>(R.id.editTextText).error = "Name cannot be empty"
            isValid = false
        }

        if (enteredPassword.length < 6) {
            findViewById<EditText>(R.id.editTextTextPassword2).error = "Password must be at least 6 characters"
            isValid = false
        }

        // Check if entered name and password match the registered ones
        if (registeredName == null || registeredPassword == null) {
            Toast.makeText(this, "No registered user found! Please sign up first.", Toast.LENGTH_SHORT).show()
            isValid = false
        } else if (enteredName != registeredName || enteredPassword != registeredPassword) {
            Toast.makeText(this, "Invalid Name or Password!", Toast.LENGTH_SHORT).show()
            isValid = false
        }

        return isValid
    }
}
