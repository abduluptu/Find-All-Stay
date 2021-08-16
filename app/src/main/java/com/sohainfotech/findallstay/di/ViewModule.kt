package com.sohainfotech.findallstay.di

import com.sohainfotech.findallstay.viewmodel.LoginRegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginRegisterViewModel(get()) }
}