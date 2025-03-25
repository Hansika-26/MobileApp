package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val nameField: EditText = findViewById(R.id.editTextText2)
        val phoneField: EditText = findViewById(R.id.editTextPhone3)
        val emailField: EditText = findViewById(R.id.editTextTextPostalAddress2)
        val addressField: EditText = findViewById(R.id.editTextTextPostalAddress2)
        val passwordField: EditText = findViewById(R.id.password1)
        val confirmPasswordField: EditText = findViewById(R.id.password2)
        val checkBox: CheckBox = findViewById(R.id.checkBox)
        val registerButton: Button = findViewById(R.id.Sign_Up)

        // SharedPreferences to store user data
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        registerButton.setOnClickListener {
            if (validateInputs(nameField, phoneField, emailField, addressField, passwordField, confirmPasswordField, checkBox)) {
                val name = nameField.text.toString().trim()
                val password = passwordField.text.toString()

             /*   // Check if the user is already registered
                val existingName = sharedPreferences.getString("name", null)
                if (existingName == name) {
                    Toast.makeText(this, "User already registered!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
*/
                // Save user details in SharedPreferences
                editor.putString("name", name)
                editor.putString("password", password)
                editor.apply()

                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()

                // Proceed to Login page
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun validateInputs(
        nameField: EditText,
        phoneField: EditText,
        emailField: EditText,
        addressField: EditText,
        passwordField: EditText,
        confirmPasswordField: EditText,
        checkBox: CheckBox
    ): Boolean {
        val name = nameField.text.toString().trim()
        val phone = phoneField.text.toString().trim()
        val email = emailField.text.toString().trim()
        val address = addressField.text.toString().trim()
        val password = passwordField.text.toString()
        val confirmPassword = confirmPasswordField.text.toString()

        // Name validation
        if (name.isEmpty()) {
            nameField.error = "Name cannot be empty"
            return false
        }

        // Phone number validation
        if (phone.length != 10 || !phone.matches(Regex("\\d{10}"))) {
            phoneField.error = "Enter a valid 10-digit phone number"
            return false
        }

        // Email validation
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailField.error = "Enter a valid email address"
            return false
        }

        // Address validation
        if (address.isEmpty()) {
            addressField.error = "Address cannot be empty"
            return false
        }

        // Password validation
        if (password.length < 6) {
            passwordField.error = "Password must be at least 6 characters"
            return false
        }

        // Confirm Password validation
        if (password != confirmPassword) {
            confirmPasswordField.error = "Passwords do not match"
            return false
        }

        // Checkbox validation
        if (!checkBox.isChecked) {
            Toast.makeText(this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}
