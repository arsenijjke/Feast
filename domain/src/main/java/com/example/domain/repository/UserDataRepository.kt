package com.example.domain.repository

import com.example.domain.model.UserProfileUI
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {

    val userData: Flow<UserProfileUI>

    suspend fun updateUserProfile(user: UserProfileUI)
}