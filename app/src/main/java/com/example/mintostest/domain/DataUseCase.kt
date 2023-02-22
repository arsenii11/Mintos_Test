package com.example.mintostest.domain

import com.example.mintostest.data.model.AccountResponse
import com.example.mintostest.data.repository.RepositoryImpl
import retrofit2.Response
import javax.inject.Inject

class DataUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke():Response<AccountResponse>{
         return repository.getAccountResponse()
    }
}