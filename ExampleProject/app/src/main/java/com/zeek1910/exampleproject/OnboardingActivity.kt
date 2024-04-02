package com.zeek1910.exampleproject

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var buttonNext: TextView
    private lateinit var buttonGetStarted: Button
    private lateinit var bottomPanel: LinearLayout
    private lateinit var dotsIndicator: SpringDotsIndicator

    private val onboardingAdapter = OnboardingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewPager)
        buttonNext = findViewById(R.id.buttonNext)
        buttonGetStarted = findViewById(R.id.buttonGetStarted)
        bottomPanel = findViewById(R.id.bottomPanel)
        dotsIndicator = findViewById(R.id.dotsIndicator)
        viewPager.adapter = onboardingAdapter
        dotsIndicator.attachTo(viewPager)

        val appSettings = AppSettings(this)
        appSettings.isShowOnboarding = false

        buttonNext.setOnClickListener {
            viewPager.currentItem++
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                buttonGetStarted.isVisible = position == 3
            }
        })
    }
}