package com.example.appsharedpref

import android.content.Context

class SharedPreference(val context: Context) {
    private val PREFS_NAME = "sharedPreferenceU"

    private val sharedPreference = context.getSharedPreferences(
        PREFS_NAME, Context.MODE_PRIVATE
    )
    fun save(keyName: String, value: String){
        val editor = sharedPreference.edit()
        editor.putString(keyName, value)
        editor.commit()
    }
    fun getValue(keyName: String):String?
    {
        return sharedPreference.getString(keyName,null)
    }

    fun removeValue(keyName: String)
    {
        val editor = sharedPreference.edit()
        editor.remove(keyName)
        editor.commit()
    }
    fun clearSharedPreference(keyName: String)
    {
        val editor = sharedPreference.edit()
        editor.clear()
        editor.commit()
    }


}