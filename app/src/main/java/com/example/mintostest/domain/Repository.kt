package com.example.mintostest.domain

import com.example.mintostest.data.api.RetrofitInstance
import retrofit2.Response
import retrofit2.http.POST

class Repository {
    suspend fun getAccountResponse():Response<AccountResponse>{
        return RetrofitInstance.api.getData()
    }
}