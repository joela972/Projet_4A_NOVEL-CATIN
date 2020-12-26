package com.example.projet4anovel_catin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projet4anovel_catin.data.local.models.UserLocal

@Database(entities = arrayOf(
    UserLocal::class
), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}