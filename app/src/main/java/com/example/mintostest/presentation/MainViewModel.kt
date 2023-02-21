package com.example.mintostest.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mintostest.data.model.AccountResponse
import com.example.mintostest.data.repository.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel (private val repository: Repository): ViewModel(){

    val myResponse: MutableLiveData<AccountResponse> = MutableLiveData()

    fun getData(){
        viewModelScope.launch {
            val response: AccountResponse = repository.getAccountResponse()
            myResponse.value= response
        }
    }

}