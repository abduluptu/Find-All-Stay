package com.sohainfotech.findallstay.data.repository

import com.sohainfotech.findallstay.data.network.ApiService
import com.sohainfotech.findallstay.model.LoginRegisterResponse
import com.sohainfotech.findallstay.model.ModuleRetro
import retrofit2.Response

class LoginRegisterRepository constructor(private val apiService: ApiService) {

    suspend fun registerUser(
        name: String,
        mobile: String,
        email: String,
        password: String,
        deviceId: String
    ) : Response<LoginRegisterResponse> {

       return apiService.registerUser(name, mobile, email, password, deviceId)
    }


    //just for test-----------------
    suspend fun postForm(userId: Int, id: Int, title: String, body: String): Response<ModuleRetro>
    {
        return apiService.sendPostForm(userId, id, title, body)
    }

}