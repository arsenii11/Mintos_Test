package com.example.mintostest.presentation

import androidx.lifecycle.ViewModel
import com.example.mintostest.domain.ShowDataUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val useCase: ShowDataUseCase,
) : ViewModel() {


}