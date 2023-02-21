package com.example.mintostest.DI

import com.example.di_dagger_lesson.example2.data.datasource.*
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindLocalDataSource(impl: RemoteDataSourceImpl): RemoteDataSource

}