package com.sohainfotech.findallstay.data.network

import com.sohainfotech.findallstay.model.LoginRegisterResponse
import com.sohainfotech.findallstay.model.ModuleRetro
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }

    @FormUrlEncoded
    @POST("posts")
    suspend fun registerUser(
        @Field("name") name: String,
        @Field("mobile") mobile: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("deviceId") deviceId: String
    ): Response<LoginRegisterResponse>


    //just for test----------------------
    @FormUrlEncoded
    @POST("posts")
    suspend fun sendPostForm(
        @Field("userId") userId: Int,
        @Field("id") id: Int,
        @Field("title") title: String,
        @Field("body") body: String
    ): Response<ModuleRetro>
}