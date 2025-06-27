package com.example.feast

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck

@Module
@InstallIn(SingletonComponent::class)
object SomeModule {

    @Module
    @DisableInstallInCheck
    object ProvideModule {

        @Provides
        fun provideTheColorApplication(application: Application): FeastApplication =
            application as FeastApplication

    }

}