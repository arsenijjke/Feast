package com.example.data.repository.model

import com.example.domain.model.Gender
import kotlinx.serialization.Serializable

@Serializable
data class UserPreference(
    val name: String?,
    val age: Int?,
    val weight: Int?,
    val height: Int?,
    val theme: Int?,
    val gender: Gender?,
) {

    companion object {
        fun getDefaultInstance() = UserPreference(
            name = null,
            age = null,
            weight = null,
            height = null,
            theme = null,
            gender = Gender.OTHER,
        )
    }
}
