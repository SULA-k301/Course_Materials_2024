package com.zeek1910.exampleproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttonLogOut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userStorage = UserStorage(this)

        buttonLogOut = findViewById(R.id.buttonLogOut)
        buttonLogOut.setOnClickListener {
            userStorage.clear()
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
    }
}