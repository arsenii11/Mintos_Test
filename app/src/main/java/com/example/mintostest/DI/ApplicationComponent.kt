package com.example.mintostest.DI


import com.example.mintostest.domain.DomainModule
import com.example.mintostest.presentation.MainActivity
import dagger.Component



@Component(modules = [ DomainModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
}