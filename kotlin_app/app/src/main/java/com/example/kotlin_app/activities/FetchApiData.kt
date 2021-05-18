package com.example.kotlin_app.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin_app.R
import kotlinx.android.synthetic.main.activity_fetch_api_data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FetchApiData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch_api_data)


    }


}