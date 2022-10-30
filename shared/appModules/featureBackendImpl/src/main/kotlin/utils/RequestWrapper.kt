package utils

import io.ktor.client.plugins.*
import domain.RequestResult

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

