package com.example.mintostest.domain

import com.example.mintostest.data.api.RetrofitInstance
import com.example.mintostest.data.model.AccountResponse
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor() {
    suspend fun getAccountResponse():Response<AccountResponse>{
        return RetrofitInstance.api.getData()
    }
}