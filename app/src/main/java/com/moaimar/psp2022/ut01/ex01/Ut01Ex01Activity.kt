package com.moaimar.psp2022.ut01.ex01

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.moaimar.psp2022.R


class Ut01Ex01Activity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex01)
        val label = findViewById<TextView>(R.id.label)
        label.text = getString(R.string.title)

        Thread{
            Thread.sleep(2000)
            runOnUiThread(){
                label.text= "Cambiado!"

            }
            Thread.sleep(2000)
            label.text = "Cambiado2"
            Log.d("dev","Thread1")
        }.start()
    }
}