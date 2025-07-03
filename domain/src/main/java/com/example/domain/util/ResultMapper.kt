package com.example.domain.util

import javax.inject.Inject
import kotlin.Result as KotlinResult

class ResultMapper @Inject constructor() {

    @Throws(IllegalStateException::class)
    fun <T> KotlinResult<T>.toDomainResult(): Result<T> =
        this.fold(
            onSuccess = { value ->
                Result.Success(value)
            },
            onFailure = { throwable ->
                error("Cannot map $throwable to Result.Failure")
            },
        )
}