package com.example.mintostest.data.repository

import com.example.mintostest.data.api.RetrofitInstance
import com.example.mintostest.data.model.AccountResponse
import com.example.mintostest.domain.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor():Repository {

    override suspend fun getAccountResponse():Response<AccountResponse>{
        return RetrofitInstance.api.getData()
    }
}