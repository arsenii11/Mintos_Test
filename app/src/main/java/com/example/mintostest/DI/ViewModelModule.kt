package com.example.mintostest.DI

import androidx.lifecycle.ViewModel
import com.example.mintostest.presentation.MainViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey


@Module
interface ViewModelModule {


    @Binds
    fun bindExampleViewModel(impl: MainViewModel):ViewModel


}