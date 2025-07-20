package com.example.data.repository.impl

import com.example.data.repository.datastore.FeastPreferencesDataSource
import com.example.domain.model.UserProfile
import com.example.domain.repository.UserDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val feastPreferencesDataSource: FeastPreferencesDataSource
) : UserDataRepository {

    override val userData: Flow<UserProfile> = feastPreferencesDataSource.userData

    override suspend fun updateUserProfile(user: UserProfile) =
        feastPreferencesDataSource.updateProfile(user)

}
