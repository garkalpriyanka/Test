package com.example.kotlin_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_app.MainActivity
import com.example.kotlin_app.R
import com.example.kotlin_app.UI.AnkoActivityUI
import org.jetbrains.anko.setContentView

class AnkoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_anko)
        AnkoActivityUI().setContentView(this)
    }
}