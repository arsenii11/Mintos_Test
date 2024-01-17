package com.example.mintostest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mintostest.data.model.AccountResponse
import com.example.mintostest.domain.DataUseCase
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: DataUseCase) : ViewModel() {

    private val _loadingState: MutableLiveData<Boolean> = MutableLiveData()
    val loadingState: LiveData<Boolean> get() = _loadingState

    private val _errorState: MutableLiveData<String> = MutableLiveData()
    val errorState: LiveData<String> get() = _errorState

    val myResponse: MutableLiveData<Response<AccountResponse>> = MutableLiveData()

    fun fetchAccountData() {
        _loadingState.value = true
        viewModelScope.launch {
            try {
                val response: Response<AccountResponse> = repository.invoke()
                myResponse.value = response
            } catch (e: Exception) {
                _errorState.value = "Failed to fetch data"
            } finally {
                _loadingState.value = false
            }
        }
    }
}

