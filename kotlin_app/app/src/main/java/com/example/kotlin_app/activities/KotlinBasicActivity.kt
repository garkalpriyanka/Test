package com.example.kotlin_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_app.R

class KotlinBasicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_basic)
    }
    fun accessInANother(){
        println("this is basic kotlin ACTIVITY")
    }
}