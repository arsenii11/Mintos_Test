package com.example.mintostest.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mintostest.domain.AccountResponse
import com.example.mintostest.data.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel (private val repository: Repository): ViewModel(){

    val myResponse: MutableLiveData<Response<AccountResponse>> = MutableLiveData()

    fun getAccountData(){
        viewModelScope.launch {
            val response: Response<AccountResponse> = repository.getAccountResponse()
            myResponse.value= response
        }
    }

}