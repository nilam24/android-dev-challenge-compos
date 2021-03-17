package com.example.androiddevchallenge

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

class MyContext() : AppCompatActivity() {

    companion object{
        fun getInstance() : MyContext{
            return MyContext()
        }
    }

    @Composable
    fun getMyAppContext():Context{
        val context = LocalContext.current
        return context
    }
}