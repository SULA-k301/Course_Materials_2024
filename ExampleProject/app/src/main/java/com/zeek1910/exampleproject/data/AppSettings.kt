package com.zeek1910.exampleproject.data

import android.content.Context
import androidx.core.content.edit

class AppSettings(context: Context) {

    private val preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var isShowOnboarding: Boolean
        get() = preferences.getBoolean(KEY_IS_SHOW_ONBOARDING, true)
        set(value) {
            preferences.edit { putBoolean(KEY_IS_SHOW_ONBOARDING, value) }
        }

    companion object {
        private const val PREF_NAME = "app_settings.pref"
        private const val KEY_IS_SHOW_ONBOARDING = "KEY_IS_SHOW_ONBOARDING"
    }
}