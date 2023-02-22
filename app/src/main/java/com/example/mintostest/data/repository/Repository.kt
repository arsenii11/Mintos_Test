package com.example.mintostest.data.repository

import com.example.mintostest.data.api.RetrofitInstance
import com.example.mintostest.domain.AccountResponse
import retrofit2.Response

class Repository {
    suspend fun getAccountResponse():Response<AccountResponse>{
        return RetrofitInstance.api.getData()
    }
}