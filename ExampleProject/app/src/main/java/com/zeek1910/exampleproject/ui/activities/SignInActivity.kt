package com.zeek1910.exampleproject.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zeek1910.exampleproject.R
import com.zeek1910.exampleproject.data.UserStorage

class SignInActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var buttonLogin: Button
    private lateinit var signUpHelperText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val userStorage = UserStorage(this)

        email = findViewById(R.id.emailEditText)
        password = findViewById(R.id.password)
        buttonLogin = findViewById(R.id.buttonLogin)
        signUpHelperText = findViewById(R.id.signUpHelperText)

        buttonLogin.setOnClickListener {
            val user = userStorage.getUser()
            val userEmail = email.text.toString()
            val userPassword = password.text.toString()
            if (userEmail == user?.email && userPassword == user.password){
                Toast.makeText(this, "Login successfully!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "Login failed!!!!", Toast.LENGTH_SHORT).show()
            }
        }

        signUpHelperText.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}