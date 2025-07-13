package com.example.data.repository

import com.example.domain.repository.DailyRateRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DiDataModule {

    @Binds
    internal abstract fun bindsDailyRateRepository(
        dailyRateRepository: DailyRateRepository
    ): DailyRateRepositoryImpl

}