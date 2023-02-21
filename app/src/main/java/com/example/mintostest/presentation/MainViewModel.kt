package com.example.mintostest.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
) : ViewModel() {

    fun method() {
        Log.d("MainViewModel", "$this")
    }


}