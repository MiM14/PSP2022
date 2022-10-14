package com.moaimar.psp2022.ut02.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.moaimar.psp2022.R
import com.moaimar.psp2022.ut02.ex02.data.remote.RetrofitApiClient

        val apiClient= RetrofitApiClient()
class Ut02Ex02Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut02_ex02)

        Thread{
          val alerts = apiClient.getAlerts()
          val alert = apiClient.getAlertById(3003191)
          Log.d("@dev","$alerts")
        }.start()

    }
}