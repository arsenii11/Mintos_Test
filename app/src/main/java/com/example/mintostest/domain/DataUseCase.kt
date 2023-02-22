package com.example.mintostest.domain

import com.example.mintostest.data.AccountResponse
import retrofit2.Response

class DataUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke():Response<AccountResponse>{
         return repository.getAccountResponse()
    }
}