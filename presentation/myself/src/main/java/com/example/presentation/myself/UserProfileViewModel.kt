package com.example.presentation.myself

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Gender
import com.example.domain.model.UserProfile
import com.example.domain.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository,
) : ViewModel() {

    private val _userProfileState = MutableStateFlow<UserProfileUiState>(UserProfileUiState.Loading)
    val userProfileState = _userProfileState.asStateFlow()

    init {
        viewModelScope.launch {
            _userProfileState.value = UserProfileUiState.Success(profile = initialData())
        }
    }

    private suspend fun initialData(): UserProfile {
        return userDataRepository.userData.first()
    }

    fun updateUsername(name: String) {
        _userProfileState.update { state ->
            val newData = (state as UserProfileUiState.Success).profile.copy(
                name = name
            )
            UserProfileUiState.Success(newData)
        }
    }

    fun updateWeight(weight: Int) {
        _userProfileState.update { state ->
            val newData = (state as UserProfileUiState.Success).profile.copy(
                weight = weight
            )
            UserProfileUiState.Success(newData)
        }
    }

    fun updateHeight(height: Int) {
        _userProfileState.update { state ->
            val newData = (state as UserProfileUiState.Success).profile.copy(
                height = height
            )
            UserProfileUiState.Success(newData)
        }
    }

    fun updateAge(age: Int) {
        _userProfileState.update { state ->
            val newData = (state as UserProfileUiState.Success).profile.copy(
                age = age
            )
            UserProfileUiState.Success(newData)
        }
    }

    fun updateGender(gender: Gender) {
        _userProfileState.update { state ->
            val newData = (state as UserProfileUiState.Success).profile.copy(
                gender = gender
            )
            UserProfileUiState.Success(newData)
        }
    }

    fun updateProfile() {
        viewModelScope.launch {
            userDataRepository.updateUserProfile(
                _userProfileState
                    .filterIsInstance<UserProfileUiState.Success>()
                    .first()
                    .profile
            )
        }
    }
}

sealed interface UserProfileUiState {
    data object Loading : UserProfileUiState

    data class Success(val profile: UserProfile) : UserProfileUiState
}
