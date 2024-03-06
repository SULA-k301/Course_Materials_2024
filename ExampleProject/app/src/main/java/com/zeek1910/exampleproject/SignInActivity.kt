package com.zeek1910.exampleproject

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignInActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        //email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        buttonLogin = findViewById(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val userEmail = ""
            val userPassword = password.text.toString()
            if (userEmail == VALID_EMAIL && userPassword == VALID_PASSWORD){
                Toast.makeText(this, "Login successfully!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Login failed!!!!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object{
        private const val VALID_EMAIL = "test@test.com"
        private const val VALID_PASSWORD = "qwerty1234"
    }
}