package com.moaimar.psp2022.ut02.ex01.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.moaimar.psp2022.R
import com.moaimar.psp2022.ut02.ex01.data.remote.RetrofitApiClient

class MainActivity : AppCompatActivity() {

    val apiClient= RetrofitApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread{
            val list = apiClient.getUsers()
            val user = apiClient.getUser(3)
            Log.d("@dev","$list")

        }.start()
    }
}