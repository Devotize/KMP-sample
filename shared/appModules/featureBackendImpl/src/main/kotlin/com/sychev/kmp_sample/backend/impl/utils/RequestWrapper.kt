package com.sychev.kmp_sample.backend.impl.utils

import io.ktor.client.plugins.*
import com.sychev.kmp_sample.backend.api.domain.models.RequestResult

fun <T : Any> safeRequest(call: () -> T): RequestResult<T> {
    return try {
        val result = call.invoke()
        RequestResult.Success(result = result)
    } catch (e: ClientRequestException) {
        RequestResult.Error(
            code = e.response.status.value.toString(),
            message = e.localizedMessage ?: ""
        )
    }
}

