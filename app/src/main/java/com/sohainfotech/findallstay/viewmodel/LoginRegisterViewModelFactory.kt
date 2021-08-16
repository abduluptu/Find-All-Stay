package com.sohainfotech.findallstay.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sohainfotech.findallstay.data.repository.LoginRegisterRepository

class LoginRegisterViewModelFactory (private val repository: LoginRegisterRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginRegisterViewModel(repository) as T
    }
}