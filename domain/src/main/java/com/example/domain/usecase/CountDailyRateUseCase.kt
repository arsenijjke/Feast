package com.example.domain.usecase

import com.example.domain.model.UserInfo
import com.example.domain.repository.CalorieRate
import com.example.domain.repository.DailyRateRepository
import javax.inject.Inject

class CountDailyRateUseCase @Inject constructor(
    private val dailyRateRepository: DailyRateRepository
) {
    suspend fun invoke(info: UserInfo): Result<CalorieRate> = dailyRateRepository.getDailyCalorieRate(info)
}
