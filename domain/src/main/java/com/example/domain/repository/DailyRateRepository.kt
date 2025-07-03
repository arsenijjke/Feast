package com.example.domain.repository

import com.example.domain.model.UserInfo

@JvmInline
value class CalorieRate(val value: Int)

interface DailyRateRepository {
    suspend fun getDailyCalorieRate(info: UserInfo): Result<CalorieRate>
}
