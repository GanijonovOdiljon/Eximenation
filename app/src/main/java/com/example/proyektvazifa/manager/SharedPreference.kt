package com.example.proyektvazifa.manager

import android.content.Context
import android.content.SharedPreferences
import android.provider.ContactsContract.CommonDataKinds.Email
import com.example.proyektvazifa.util.Constants.EMAIL
import com.example.proyektvazifa.util.Constants.PASS
import com.example.proyektvazifa.util.Constants.PREFS_NAME

class SharedPreferences(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun saveData(email: String,pass:String){
        val edit = sharedPreferences.edit()
        edit.putString(EMAIL, email)
        edit.putString(PASS, pass)
        edit.apply()
    }
    fun getData(key: String): String?{
        return sharedPreferences.getString(key,null)
    }
    fun  clear(){
        val edit = sharedPreferences.edit()
        edit.clear()
        edit.apply()
    }
}