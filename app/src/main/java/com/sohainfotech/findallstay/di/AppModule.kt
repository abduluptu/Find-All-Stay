package com.sohainfotech.findallstay.di

import com.sohainfotech.findallstay.data.network.providesApiService
import com.sohainfotech.findallstay.data.network.providesMoshi
import com.sohainfotech.findallstay.data.network.providesRetrofitBuilder
import com.sohainfotech.findallstay.data.repository.LoginRegisterRepository
import com.sohainfotech.findallstay.model.LoginRegisterResponse
import com.sohainfotech.findallstay.viewmodel.LoginRegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.component.KoinApiExtension
import org.koin.dsl.bind
import org.koin.dsl.module

@OptIn(KoinApiExtension::class)
val appModule = module {

    //retrofit
    single { providesMoshi() }
    single { providesRetrofitBuilder(get()) }
    single { providesApiService(get()) }

}