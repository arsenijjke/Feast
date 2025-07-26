package com.example.domain.repository

import com.example.domain.model.UserProfile
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {

    val userData: Flow<UserProfile>

    suspend fun updateUserProfile(profile: UserProfile)
}