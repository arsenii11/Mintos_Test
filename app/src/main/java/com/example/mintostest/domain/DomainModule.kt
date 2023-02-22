package com.example.mintostest.domain

import com.example.mintostest.data.repository.RepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {
    @Binds
    fun bindRepository(impl: RepositoryImpl):Repository
}