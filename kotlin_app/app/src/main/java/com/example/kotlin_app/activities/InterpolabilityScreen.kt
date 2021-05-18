package com.example.kotlin_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_app.R
import com.example.kotlin_app.java.interpolabiltyy

class InterpolabilityScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interpolability_screen)
        var area = interpolabiltyy.getArea(2,3)
println("Area is " +area)
    }
}