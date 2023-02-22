package com.example.mintostest.domain

import com.example.mintostest.data.api.RetrofitInstance
import com.example.mintostest.data.model.AccountResponse
import retrofit2.Response

class Repository {
    suspend fun getAccountResponse():Response<AccountResponse>{
        return RetrofitInstance.api.getData()
    }
}