package com.example.kotlin_app.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.kotlin_app.DB.MyDBHelper
import com.example.kotlin_app.R
import com.example.kotlin_app.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    lateinit var MyDBHelper: MyDBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        MyDBHelper = MyDBHelper(this)
        btnlogin1.setOnClickListener() {
            if(MyDBHelper.userLogin(userName.text.toString(), password.text.toString())){

//
                Toast.makeText(this, R.string.login_success, Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, R.string.login_failed, Toast.LENGTH_SHORT).show()

            }
        }

    }
}