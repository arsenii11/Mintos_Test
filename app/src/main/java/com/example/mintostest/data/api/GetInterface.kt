package com.example.mintostest.data.api


import com.example.mintostest.data.model.AccountResponse
import retrofit2.Response
import retrofit2.http.GET

interface GetInterface {

    @GET("bank-account.json")
    suspend fun getData(): Response<AccountResponse>

}