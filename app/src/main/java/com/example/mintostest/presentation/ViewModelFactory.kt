package com.example.mintostest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mintostest.domain.ShowDataUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
private val showDataUseCase: ShowDataUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == ShowDataUseCase::class.java){
        return MainViewModel(showDataUseCase) as T
        }
        throw java.lang.RuntimeException("Unknown view model class $modelClass")
    }

}