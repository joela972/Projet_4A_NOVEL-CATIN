package com.example.projet4anovel_catin.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.projet4anovel_catin.data.local.models.UserLocal



@Dao
interface DatabaseDao {
    @Query("SELECT * FROM userlocal")
    fun getAll(): List<UserLocal>

    @Query("SELECT * FROM userLocal WHERE email LIKE :email LIMIT 1")
    fun findByName(email: String): UserLocal?

    @Query("SELECT * FROM userlocal WHERE email LIKE :email AND password LIKE :password " +
                       "LIMIT 1")
    fun findByMailPassword(email: String, password : String): UserLocal?

    @Insert
    fun insert(user: UserLocal)

    @Delete
    fun delete(user: UserLocal)
}

