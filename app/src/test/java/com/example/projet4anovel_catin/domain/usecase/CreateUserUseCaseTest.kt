package com.example.projet4anovel_catin.domain.usecase

import com.example.projet4anovel_catin.data.repository.UserRepository
import com.example.projet4anovel_catin.domain.entity.User
import io.mockk.coEvery
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CreateUserUseCaseTest {
    private val userRepository: UserRepository = mockk()
    private val classUnderTest = CreateUserUseCase(userRepository)

    @Test
    fun invoke() {
        runBlocking {
            //GIVEN
            val user = User("")
            coEvery { userRepository.createUser(user) } returns Unit

            //WHEN
            classUnderTest.invoke(user)
            //THEN
            coVerify(exactly = 1) { userRepository.createUser(user) }
            }
        }
    }
