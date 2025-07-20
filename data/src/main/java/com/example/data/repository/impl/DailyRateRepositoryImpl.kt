package com.example.data.repository.impl

import com.example.domain.model.Gender
import com.example.domain.model.UserProfile
import com.example.domain.repository.CalorieRate
import com.example.domain.repository.DailyRateRepository
import com.example.domain.util.ResultMapper
import javax.inject.Inject

class DailyRateRepositoryImpl @Inject constructor(
    private val resultMapper: ResultMapper
) : DailyRateRepository {

    // BRM = (10 * weight (kg)) + (6.25 * height (cm)) - (5 * age (y))
    // +5 for Male
    // -161 for Female

    override suspend fun getDailyCalorieRate(info: UserProfile): Result<CalorieRate> {
        val baseCalorieRate = ((10 * (info.weight ?: 0)) + (6.25 * (info.height ?: 0)) - (5 * (info.age ?: 0))).toInt()
        return if(info.gender == Gender.MALE) {
            Result.success(CalorieRate(value = (baseCalorieRate + 5)))
        } else {
            Result.success(CalorieRate(value = (baseCalorieRate - 161)))
        }
    }
}
