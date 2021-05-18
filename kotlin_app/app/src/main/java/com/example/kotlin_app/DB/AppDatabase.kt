package com.example.kotlin_app.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlin_app.Dao.UserDao
import com.example.kotlin_app.entity.User

//class AppDatabase {
//}

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}