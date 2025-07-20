package com.example.domain.model

data class UserProfileUI(
    val name: String?,
    val age: Int?,
    val weight: Int?,
    val height: Int?,
    val gender: Gender,
    val theme: Int?,
)
