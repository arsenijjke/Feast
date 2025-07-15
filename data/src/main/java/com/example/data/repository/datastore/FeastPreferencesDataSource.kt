package com.example.data.repository.datastore

import androidx.datastore.core.DataStore
import com.example.data.repository.model.UserPreference
import com.example.data.repository.model.UserProfileUI
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FeastPreferencesDataSource @Inject constructor(
    private val userPreference: DataStore<UserPreference>
) {
    val userData = userPreference.data
        .map {
            UserPreference(
                age = it.age,
                height = it.height,
                name = it.name,
                theme = it.theme,
                weight = it.weight,
            )
        }

    suspend fun updateProfile(userProfile: UserProfileUI) {

    }

    suspend fun updateTheme() {

    }
}