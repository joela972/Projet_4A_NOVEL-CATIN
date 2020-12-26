package com.example.projet4anovel_catin.domain.usecase

import com.example.projet4anovel_catin.data.repository.UserRepository
import com.example.projet4anovel_catin.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String){
        userRepository.getUser(email)
    }
}
