package com.zeek1910.exampleproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {

    private lateinit var buttonRegister: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val userStorage = UserStorage(this)

        buttonRegister = findViewById(R.id.buttonRegister)
        buttonRegister.setOnClickListener {
            val email = "test@test.com"
            val password = "123456"
            if (isEmailValid(email) && isPasswordValid(password)) {
                val user = User(
                    name = "Test",
                    email = email,
                    password = password
                )
                userStorage.saveUser(user)
                Toast.makeText(this, "User created successfully!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Email or password is not valid", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun isEmailValid(email: String): Boolean {
        return email.contains("@")
    }

    fun isPasswordValid(password: String): Boolean {
        return password.length >= 6
    }
}