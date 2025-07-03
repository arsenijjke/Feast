package com.example.domain.model

data class UserInfo(
    val height: Int,
    val weight: Int,
    val gender: Gender,
    val age: Int,
)

sealed class Gender {
    object Male: Gender()
    object Female: Gender()
    object Other: Gender()
}
