package com.example.feast.navigation.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.presentation.myself.UserProfile
import com.example.presentation.myself.UserProfileViewModel

@Composable
fun HomeScreen() {
    val mySelfViewModel = hiltViewModel<UserProfileViewModel>()
    UserProfile(
        viewModel = mySelfViewModel
    )
}