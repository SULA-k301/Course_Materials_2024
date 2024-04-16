package com.zeek1910.exampleproject.data

import android.content.Context
import androidx.core.content.edit
import com.zeek1910.exampleproject.models.User

class UserStorage(context: Context) {

    private val preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    /**
     * Return current user or null if user doesn't exist
     */
    fun getUser(): User? {
        val name = preferences.getString(KEY_USER_NAME, null)
        val email = preferences.getString(KEY_EMAIL, null)
        val password = preferences.getString(KEY_PASSWORD, null)
        if (email.isNullOrBlank() || password.isNullOrBlank()) {
            return null
        }
        return User(name, email, password)
    }

    /**
     * Saves current user into local storage
     */
    fun saveUser(user: User){
        preferences.edit {
            putString(KEY_USER_NAME, user.name)
            putString(KEY_EMAIL, user.email)
            putString(KEY_PASSWORD, user.password)
        }
    }
    
    fun clear(){
        preferences.edit { clear() }
    }

    companion object {
        private const val PREF_NAME = "user_storage.pref"
        private const val KEY_USER_NAME = "userName"
        private const val KEY_EMAIL = "email"
        private const val KEY_PASSWORD = "password"
    }
}