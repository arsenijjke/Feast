package com.example.data.repository.model

import com.example.domain.model.UserProfileUI
import kotlinx.serialization.Serializable

@Serializable
data class UserPreference(
    val name: String?,
    val age: Int?,
    val weight: Int?,
    val height: Int?,
    val theme: Int?
) {

    fun UserPreference.toUserProfileUI() = UserProfileUI(
        name = this.name ?: "",
        age = this.age ?: 0,
        weight = this.weight ?: 0,
        height = this.height ?: 0,
        theme = this.theme ?: 0,
    )

    companion object {
        fun getDefaultInstance() = UserPreference(
            name = null,
            age = null,
            weight = null,
            height = null,
            theme = null,
        )
    }
}
