package com.sohainfotech.findallstay.di

import com.sohainfotech.findallstay.data.repository.LoginRegisterRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { LoginRegisterRepository(get()) }
}