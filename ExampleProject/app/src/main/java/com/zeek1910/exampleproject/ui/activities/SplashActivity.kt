package com.zeek1910.exampleproject.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.zeek1910.exampleproject.data.AppSettings
import com.zeek1910.exampleproject.R
import com.zeek1910.exampleproject.data.UserStorage
import com.zeek1910.exampleproject.ui.activities.onboarding.OnboardingActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val userStorage = UserStorage(this)
        val appSettings = AppSettings(this)

        Handler(Looper.getMainLooper()).postDelayed({
            if (appSettings.isShowOnboarding) {
                startActivity(Intent(this, OnboardingActivity::class.java))
            } else {
                if (userStorage.getUser() == null) {
                    startActivity(Intent(this, SignInActivity::class.java))
                } else {
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
            finish()
        }, 1000)
    }
}