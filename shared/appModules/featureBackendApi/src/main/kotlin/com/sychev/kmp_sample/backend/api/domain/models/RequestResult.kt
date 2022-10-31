package com.sychev.kmp_sample.backend.api.domain.models

sealed class RequestResult<T : Any> {
    class Success<T: Any>(val result: T) : RequestResult<T>()
    class Error<T: Any>(val code: String, val message: String) : RequestResult<T>()
}