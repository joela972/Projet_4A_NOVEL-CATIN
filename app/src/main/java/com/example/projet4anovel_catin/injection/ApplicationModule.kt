package com.example.projet4anovel_catin.injection

import com.example.projet4anovel_catin.MainViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val presentationModule: Module = module {
    factory {MainViewModel() }
}