package com.example.mintostest.data.api

import com.example.mintostest.data.model.AccountResponse
import com.example.mintostest.data.util.Links.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GetInterface {

    @GET(BASE_URL)
    suspend fun getData(): AccountResponse

}