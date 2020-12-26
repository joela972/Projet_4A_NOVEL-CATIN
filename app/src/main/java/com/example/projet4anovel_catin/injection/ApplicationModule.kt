package com.example.projet4anovel_catin.injection

import android.content.Context
import androidx.core.content.contentValuesOf
import androidx.room.Room
import com.example.projet4anovel_catin.data.local.AppDatabase
import com.example.projet4anovel_catin.data.local.DatabaseDao
import com.example.projet4anovel_catin.presentation.main.MainViewModel
import com.example.projet4anovel_catin.domain.usecase.CreateUserUseCase
import com.example.projet4anovel_catin.data.repository.UserRepository
import com.example.projet4anovel_catin.domain.usecase.GetUserUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val presentationModule: Module = module {
    factory { MainViewModel(get(), get()) }
}

val domainModule = module {
    factory{ CreateUserUseCase(get())}
    factory{ GetUserUseCase(get()) }
}

val dataModule :Module = module {
    single { UserRepository(get()) }
    single { createDatabase(androidContext()) }
}

fun createDatabase(context: Context): DatabaseDao {
        val appDatabase = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        ).build()
        return appDatabase.databaseDao()
}
