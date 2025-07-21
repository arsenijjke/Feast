package com.example.domain.usecase

import com.example.domain.model.UserProfile
import com.example.domain.repository.CalorieRate
import com.example.domain.repository.DailyRateRepository
import javax.inject.Inject

class CountDailyRateUseCase @Inject constructor(
    private val dailyRateRepository: DailyRateRepository
) {
    suspend operator fun invoke(info: UserProfile): Result<CalorieRate> = dailyRateRepository.getDailyCalorieRate(info)
}
