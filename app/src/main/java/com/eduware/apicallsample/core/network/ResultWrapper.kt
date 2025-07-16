package com.eduware.apicallsample.core.network

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class GenericError(
        val code: Int? = null,
        val message: String? = null,
        val type: ErrorType = ErrorType.UNKNOWN
    ) : ResultWrapper<Nothing>()

    data object NetworkError : ResultWrapper<Nothing>()
}


enum class ErrorType {
    UNAUTHORIZED,
    FORBIDDEN,
    NOT_FOUND,
    SERVER_ERROR,
    BAD_REQUEST,
    TIMEOUT,
    UNKNOWN
}