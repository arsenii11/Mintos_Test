package com.example.mintostest.domain

import com.example.mintostest.data.model.AccountResponse
import retrofit2.Response

interface Repository {

    suspend fun getAccountResponse():  Response<AccountResponse>
}