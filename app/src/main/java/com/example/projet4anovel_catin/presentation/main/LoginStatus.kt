package com.example.projet4anovel_catin.presentation.main

import android.provider.ContactsContract

sealed class LoginStatusSealed

data class LoginSuccess(val email: String) : LoginStatusSealed()
object LoginError : LoginStatusSealed()
