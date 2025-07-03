package com.example.domain.util

sealed interface Result<out T> {

    data class Success<T>(
        val value: T,
    ) : Result<T>

    sealed interface Failure : Result<Nothing> {
        val cause: Throwable
    }
}