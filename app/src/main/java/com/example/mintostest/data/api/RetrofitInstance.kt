package com.example.mintostest.data.api

import com.example.mintostest.data.util.Links
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Links.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: GetInterface by lazy {
        retrofit.create(GetInterface::class.java)
    }
}