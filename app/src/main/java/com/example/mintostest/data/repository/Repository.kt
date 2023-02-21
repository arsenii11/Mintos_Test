package com.example.mintostest.data.repository

import com.example.mintostest.data.api.RetrofitInstance
import com.example.mintostest.data.model.AccountResponse
import retrofit2.http.POST

class Repository {
    suspend fun getAccountResponse():AccountResponse{
        return RetrofitInstance.api.getData()
    }
}