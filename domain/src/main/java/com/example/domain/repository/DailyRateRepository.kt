package com.example.domain.repository

import com.example.domain.model.UserProfile

@JvmInline
value class CalorieRate(val value: Int)

interface DailyRateRepository {
    suspend fun getDailyCalorieRate(info: UserProfile): Result<CalorieRate>
}
