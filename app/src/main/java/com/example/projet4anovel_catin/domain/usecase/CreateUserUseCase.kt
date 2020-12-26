package com.example.projet4anovel_catin.domain.usecase

import com.example.projet4anovel_catin.data.repository.UserRepository
import com.example.projet4anovel_catin.domain.entity.User

class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user : User){
    return userRepository.createUser(user)
    }
}

