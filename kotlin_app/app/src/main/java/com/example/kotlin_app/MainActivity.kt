package com.example.kotlin_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.kotlin_app.DB.MyDBHelper
import com.example.kotlin_app.activities.*
import com.example.kotlin_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   lateinit var  binding: ActivityMainBinding
    val KotlinBasicActivity: KotlinBasicActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding   = DataBindingUtil.setContentView(this, R.layout.activity_main)

        helloWOrld()
        KotlinBasicActivity?.accessInANother()


        binding.btnlogin.setOnClickListener(){
            val intent =  Intent(this,LoginActivity::class.java)
            startActivity(intent)

        }
        binding.btnRegister.setOnClickListener(){
            val intent =  Intent(this,RegistrationActivity::class.java)
            startActivity(intent)

        }
        binding.btnGoToFunctionScreen.setOnClickListener(){
            val intent =  Intent(this,FunctionScreen::class.java)
            startActivity(intent)
        }
        binding.btnGoToInterpolabilityScreen.setOnClickListener(){
            val intent =  Intent(this,InterpolabilityScreen::class.java)
            startActivity(intent)
        }

        binding.btnGoToInheritanceScreen.setOnClickListener(){
            val intent =  Intent(this,InheritanceClass::class.java)
            startActivity(intent)
        }
        binding.btnGotToAnko.setOnClickListener(){
            val intent =  Intent(this,AnkoActivity::class.java)
            startActivity(intent)
        }
    }

    fun helloWOrld() {
        val x = 2 + 1
        val s = "priyanka" + "  \ngarkal"
        val a: Int = 1 // immediate assignment
        val b = 2 // `Int` type is inferred
        val c: Int // Type required when no initializer is provided
        c = 3

        println("Hi...i Love kotlin")
        println("Happy Birthday! \n")
        println("Jhansi")
        println("You are 25!")

        println("values are $x,$a,$b,$c,$s")

        for (i in 6 downTo 0 step 3) {
            println(i)
        }
        println("this is simple for!")

        for (i in 1..3) {
            println(i)
        }
    }

    fun login(){

    }


}