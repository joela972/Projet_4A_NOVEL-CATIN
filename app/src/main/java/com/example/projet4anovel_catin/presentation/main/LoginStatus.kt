package com.example.projet4anovel_catin.presentation.main

sealed class LoginStatus

data class LoginSuccess(val email: String, val password : String) : LoginStatus()
object LoginError : LoginStatus()
object LoginOK : LoginStatus()
object LoginCreate : LoginStatus()



