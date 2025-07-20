package com.example.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.example.data.repository.model.UserPreference
import com.example.data.repository.datastore.UserPreferencesSerializer
import com.example.data.repository.impl.DailyRateRepositoryImpl
import com.example.data.repository.impl.UserDataRepositoryImpl
import com.example.data.repository.util.ApplicationScope
import com.example.data.repository.util.Dispatcher
import com.example.data.repository.util.FeastDispatcher
import com.example.domain.repository.DailyRateRepository
import com.example.domain.repository.UserDataRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DiDataModule {

    @Binds
    internal abstract fun bindsUserDataRepository(
        userDataRepository: UserDataRepositoryImpl
    ): UserDataRepository

    @Binds
    internal abstract fun bindsDailyRateRepository(
        dailyRateRepository: DailyRateRepositoryImpl
    ): DailyRateRepository

}

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    internal fun provideUserPreferencesDataStore(
        @ApplicationContext context: Context,
        @Dispatcher(FeastDispatcher.IO) ioDispatcher: CoroutineDispatcher,
        @ApplicationScope scope: CoroutineScope,
        userPreferencesSerializer: UserPreferencesSerializer,
    ): DataStore<UserPreference> =
        DataStoreFactory.create(
            serializer = userPreferencesSerializer,
            scope = CoroutineScope(scope.coroutineContext + ioDispatcher),
        ) { context.dataStoreFile("prefs")}
}
