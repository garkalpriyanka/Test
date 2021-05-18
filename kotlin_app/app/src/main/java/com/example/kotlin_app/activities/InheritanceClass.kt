package com.example.kotlin_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_app.R

open class InheritanceClass : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inheritance_class)


       var x =InheritanceTest()
        x.print()

    }
}