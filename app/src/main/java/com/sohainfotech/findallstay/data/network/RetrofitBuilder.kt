package com.sohainfotech.findallstay.data.network

import com.sohainfotech.findallstay.data.repository.LoginRegisterRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun providesMoshi(): Moshi = Moshi
    .Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

fun providesRetrofitBuilder(moshi: Moshi): Retrofit =
    Retrofit.Builder()
        .run {
            baseUrl(ApiService.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
        }

//by Abdul---------------------use this to log print
private fun interceptor(): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return httpLoggingInterceptor
}
//---------------------


fun providesApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)
