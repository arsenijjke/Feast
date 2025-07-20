package com.example.presentation.myself

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.UserProfileUI
import com.example.domain.repository.UserDataRepository
import com.example.domain.usecase.CountDailyRateUseCase
import com.example.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MyselfViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository,
    private val setupCalorieRate: CountDailyRateUseCase
) : ViewModel() {

    val userProfileState: StateFlow<UserProfileUiState> =
        userDataRepository.userData
            .map { userData ->
                UserProfileUiState.Success (
                    profile = UserProfileUI(
                        name = userData.name ?: "",
                        age = userData.age ?: 0,
                        weight = userData.weight ?: 0,
                        height = userData.height ?: 0,
                        gender = userData.gender,
                        theme = null
                    )
                )
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = UserProfileUiState.Loading,
            )

}

sealed interface UserProfileUiState {
    data object Loading : UserProfileUiState
    data class Success(val profile: UserProfileUI) : UserProfileUiState
}
