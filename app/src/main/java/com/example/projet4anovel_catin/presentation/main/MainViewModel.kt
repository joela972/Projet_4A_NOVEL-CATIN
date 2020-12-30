package com.example.projet4anovel_catin.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projet4anovel_catin.domain.entity.User
import com.example.projet4anovel_catin.domain.usecase.CreateUserUseCase
import com.example.projet4anovel_catin.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser)
            val loginStatus = if(user != null){
                LoginSuccess(user.email, user.password)
                } else {
                    LoginError
                }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }
        }
    }

    fun onClickedCreate(emailUser: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            val user =  getUserUseCase.invoke(emailUser)
            val loginStatus = if(user != null){
                LoginOK
            } else {
                LoginCreate
            }
            if(loginStatus == LoginCreate){
                createUserUseCase.invoke(User(emailUser, password))
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }
        }
    }

}