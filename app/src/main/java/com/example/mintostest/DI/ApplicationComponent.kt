package com.example.mintostest.DI


import com.example.mintostest.presentation.MainActivity
import dagger.Component


@Component(
    modules = [ViewModelModule::class]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

}