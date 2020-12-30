package com.example.projet4anovel_catin.domain.usecase

import com.example.projet4anovel_catin.data.repository.UserRepository
import com.example.projet4anovel_catin.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String) :User? {
        return userRepository.getUser(email)
    }
    suspend fun invoke(email: String, password : String) :User? {
        return userRepository.getMailPassword(email, password)
    }
}
