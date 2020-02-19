package com.example.tasks.Validacao

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(conext: Context) {

    private val mSharedPreferences: SharedPreferences =
        conext.getSharedPreferences("tasks", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        mSharedPreferences.edit().putString(key, value).apply()

    }

    fun getStoredString(key: String) : String?{
        return mSharedPreferences.getString(key, "")
    }

    fun removeStoreString(key: String){
        mSharedPreferences.edit().remove(key).apply()
    }
}