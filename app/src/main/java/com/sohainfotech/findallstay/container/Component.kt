package com.sohainfotech.findallstay.container

import com.sohainfotech.findallstay.data.repository.LoginRegisterRepository
import com.sohainfotech.findallstay.viewmodel.LoginRegisterViewModel
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@KoinApiExtension
class Component : KoinComponent {

    //lazily inject
    val loginRegisterViewModel: LoginRegisterViewModel by inject()
    val loginRegisterRepository: LoginRegisterRepository by inject()
}