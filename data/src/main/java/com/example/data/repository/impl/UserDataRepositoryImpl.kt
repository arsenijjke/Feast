package com.example.data.repository.impl

import com.example.data.repository.datastore.FeastPreferencesDataSource
import com.example.domain.model.UserProfileUI
import com.example.domain.repository.UserDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val feastPreferencesDataSource: FeastPreferencesDataSource
) : UserDataRepository {

    override val userData: Flow<UserProfileUI> = feastPreferencesDataSource.userData

    override suspend fun updateUserProfile(user: UserProfileUI) =
        feastPreferencesDataSource.updateProfile(user)

}