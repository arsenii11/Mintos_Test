package com.example.mintostest.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mintostest.data.model.AccountResponse
import com.example.mintostest.domain.DataUseCase
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel (private val repository: DataUseCase): ViewModel(){

    val myResponse: MutableLiveData<Response<AccountResponse>> = MutableLiveData()

    fun getAccountData(){
        viewModelScope.launch {
            val response: Response<AccountResponse> = repository.invoke()
            myResponse.value= response
        }
    }

}