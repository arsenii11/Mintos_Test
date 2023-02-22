package com.example.mintostest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mintostest.domain.DataUseCase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val useCase: DataUseCase):
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(useCase) as T
    }
    }