package com.example.kotlin_app.activities

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.kotlin_app.DB.MyDBHelper
import com.example.kotlin_app.R
import com.example.kotlin_app.databinding.ActivityLoginBinding
import com.example.kotlin_app.databinding.ActivityRegistrationBinding
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration)
//        setContentView(R.layout.activity_registration)
        var helper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USER", null)

        if (rs.moveToNext()) {
//            Toast.makeText(applicationContext,rs.getString(1),Toast.LENGTH_SHORT).show()
            Toast.makeText(applicationContext, rs.getString(1), Toast.LENGTH_SHORT).show()

        }

        btnRegister1.setOnClickListener() {


            if (txtFN.text.toString().isEmpty()) {

                txtFN.setError("Enter valid name")
//                Toast.makeText(this, "empty fields", Toast.LENGTH_SHORT).show()

            } else if (txtUserName.text.toString().isEmpty()) {
                txtUserName.setError("Enter valid username")

            } else if (txtPassword.text.toString().isEmpty()) {
                txtPassword.setError("Enter valid password")

            } else if (txtConfirmPassword.text.toString().isEmpty() || !txtPassword.text.toString()
                    .equals(txtConfirmPassword.text.toString())
            ) {
                txtConfirmPassword.setError("password not matching")

            } else {
                var cv = ContentValues()
                cv.put("FUllNAME", txtFN.text.toString())
                cv.put("UNAME", txtUserName.text.toString())
                cv.put("PWD", txtPassword.text.toString())
                cv.put("CPWD", txtConfirmPassword.text.toString())
                db.insert("USER", null, cv)
                Toast.makeText(this, "Successfull", Toast.LENGTH_SHORT).show()

            }
        }
    }


}