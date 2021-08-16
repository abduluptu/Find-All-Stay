package com.sohainfotech.findallstay.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sohainfotech.findallstay.data.repository.LoginRegisterRepository
import com.sohainfotech.findallstay.model.LoginRegisterResponse
import com.sohainfotech.findallstay.model.ModuleRetro
import kotlinx.coroutines.launch
import retrofit2.Response


class LoginRegisterViewModel(private val loginRegisterRepository: LoginRegisterRepository) :
    ViewModel() {

    //Implement Mutable Live Data
    var loginRegResponse: MutableLiveData<Response<LoginRegisterResponse>> = MutableLiveData()

    //val myResponse: MutableLiveData<List<LoginRegisterResponse>> = MutableLiveData() //It's store data as live

    //just for test--------------
    var dataJSON: MutableLiveData<Response<ModuleRetro>> = MutableLiveData()


    fun registerUser(
        name: String,
        mobile: String,
        email: String,
        password: String,
        deviceId: String
    ) {

        viewModelScope.launch {
            //fetch data from Repository
            val response = loginRegisterRepository.registerUser(name, mobile, email, password, deviceId);
            //set response to Live Data
            loginRegResponse.value = response
        }
    }

    fun getLoginRegisterResponse(): MutableLiveData<Response<LoginRegisterResponse>>{
        return loginRegResponse;
    }

    //just for test----------------
    fun postForm(userId: Int, id: Int, title: String, body: String)
    {
        viewModelScope.launch {
            val responseForm = loginRegisterRepository.postForm(userId, id, title, body)

            dataJSON.value = responseForm
        }
    }

    //just for test----------------
    fun getTestResponse(): MutableLiveData<Response<ModuleRetro>>{
        return dataJSON
    }



}