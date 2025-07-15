package com.example.data.repository.util

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatcher: FeastDispatcher)

enum class FeastDispatcher {
    Default,
    IO
}
