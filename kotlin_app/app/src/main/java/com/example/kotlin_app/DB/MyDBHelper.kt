package com.example.kotlin_app.DB

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context) : SQLiteOpenHelper(context, "USERDB1", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
//        TODO("Not yet implemented")

//        db?.execSQL("CREATE TABLE USERS(USERID INTGER PRIMARY KEY ,UNAME TEXT,PWD TEXT)")
//        db?.execSQL("INSERT INTO USERS(UNAME,PWD) VALUES('priyanka','pcs')" )
//        db?.execSQL("INSERT INTO USERS(UNAME,PWD) VALUES('priyanka1','p1cs')" )
        db?.execSQL("CREATE TABLE USER(USERID INTGER PRIMARY KEY ,FUllNAME TEXT,UNAME TEXT,PWD TEXT,CPWD TEXT)")
        db?.execSQL("INSERT INTO USER(FUllNAME,UNAME,PWD,CPWD) VALUES('priyanka','pcs','sdsd','sddd')")
//        db?.execSQL("INSERT INTO USERS(UNAME,PWD) VALUES('priyanka1','p1cs')" )
    }


    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }


    fun userLogin(UNAME: String, PWD: String): Boolean {
        val db = writableDatabase
        val query = "select * from user where UNAME = '$UNAME' and PWD = '$PWD'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count <= 0) {
            cursor.close()
            return false
        } else {
            cursor.close()
            return true

        }
    }
}