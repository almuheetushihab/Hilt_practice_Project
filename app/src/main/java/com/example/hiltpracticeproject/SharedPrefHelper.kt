package com.example.hiltpracticeproject

import android.content.Context
import android.content.SharedPreferences

class SharedPrefHelper(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

    fun saveEmployeeName(name: String) {
        sharedPreferences.edit().putString("employee_name", name).apply()
    }

    fun getEmployeeName(): String? {
        return sharedPreferences.getString("employee_name", null)
    }

}

