package com.dsckiet.helpvault.util

import android.content.Context
import android.content.SharedPreferences
import com.dsckiet.helpvault.R

class SessionManager(context: Context) {
    private var prefs: SharedPreferences? =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
    }

    fun saveAuthToken(token: String) {
        val editor = prefs?.edit()
        editor?.putString(USER_TOKEN, token)
        editor?.apply()
    }

    fun fetchAuthToken(key: String): String? {
        return prefs?.getString(USER_TOKEN, null)
    }

    fun deleteValue(key: String) {
        val editor = prefs?.edit()
        editor?.putString(key, null)
        editor?.apply()
    }
}