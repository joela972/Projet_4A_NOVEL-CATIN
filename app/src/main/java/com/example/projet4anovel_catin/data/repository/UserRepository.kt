package com.example.projet4anovel_catin.data.repository

import com.example.projet4anovel_catin.data.local.DatabaseDao
import com.example.projet4anovel_catin.data.local.models.toData
import com.example.projet4anovel_catin.data.local.models.toEntity
import com.example.projet4anovel_catin.domain.entity.User

class  UserRepository(
    private val databaseDao: DatabaseDao
) {
    suspend fun createUser(user: User){
        databaseDao.insert(user.toData())
    }

    fun getUser(email: String) : User?{
        val userLocal = databaseDao.findByName(email)
        return userLocal?.toEntity()
    }

    fun getMailPassword(email: String, password : String) : User?{
        val userLocal = databaseDao.findByMailPassword(email, password)
        return userLocal?.toEntity()
    }
}