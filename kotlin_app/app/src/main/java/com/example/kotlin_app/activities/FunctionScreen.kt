package com.example.kotlin_app.activities

import android.animation.Animator
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.putString
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.scale
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import androidx.palette.graphics.Palette
import androidx.palette.graphics.Target.VIBRANT

import com.example.kotlin_app.R
import com.example.kotlin_app.databinding.ActivityFunctionScreenBinding
import kotlinx.android.synthetic.main.activity_function_screen.*
import kotlinx.android.synthetic.main.activity_main.*
import androidx.palette.graphics.Palette.from as paletteFrom

class FunctionScreen : AppCompatActivity() {
    lateinit var binding: ActivityFunctionScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_function_screen)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_function_screen)
        NullSafty()
        lambdaFunc()
        KTXFunction()

//This is without Palette KTX
        btnPalatte.setOnClickListener()
        {
            // get bitmap from drawable resource
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.bee)

// scale bitmap using android ktx
            val scaledBitmap = bitmap.scale(
                300, // width
                300, // height
                false // filter
            )
            imageView.setImageBitmap(scaledBitmap)
        }

        //This is Palatte KTX
        btnPalatteKTX.setOnClickListener() {

// get a drawable from resources
            val myDrawable = ContextCompat.getDrawable(this, R.drawable.bee)

// convert the drawable to a bitmap
            val bitmap = myDrawable?.toBitmap()
            imageView1.setImageBitmap(bitmap)
        }


    }

    private fun KTXFunction() {
//simple without Example
        val myUriString = "Priyanka"
        val uri = Uri.parse(myUriString)
        println("String is" + uri)
//this is using KTX Core module
        val uri1 = myUriString.toUri()
        println("String in KTX is" + uri)


    }

    fun NullSafty() {
        var name: String? = null
//val value:String = null             //null pointer exception
        println("the length of name is ${name?.length}")
//        println("the length of value is ${value.length}")

    }

    fun lambdaFunc() {
        val sum = { num1: Int, num2: Int -> num1 + num2 }
        println("10+5: ${sum(10, 5)}")
    }


}