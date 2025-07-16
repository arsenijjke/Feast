package com.example.data.repository.datastore

import androidx.datastore.core.DataStore
import com.example.data.repository.model.UserPreference
import com.example.domain.model.UserProfileUI
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FeastPreferencesDataSource @Inject constructor(
    private val userPreference: DataStore<UserPreference>
) {
    val userData = userPreference.data
        .map {
            UserProfileUI(
                age = it.age,
                height = it.height,
                name = it.name,
                theme = it.theme,
                weight = it.weight,
            )
        }

    suspend fun updateProfile(userProfile: UserProfileUI) {
        userPreference.updateData { currentPreferences ->
            currentPreferences.copy(
                name = userProfile.name.takeIf { it?.isNotEmpty() ?: false },
                age = userProfile.age.takeIf { it != 0 },
                weight = userProfile.weight.takeIf { it != 0 },
                height = userProfile.height.takeIf { it != 0 }
            )
        }
    }

    suspend fun updateTheme(theme: Int) {
        userPreference.updateData { currentPreferences ->
            currentPreferences.copy(theme = theme)
        }
    }
}