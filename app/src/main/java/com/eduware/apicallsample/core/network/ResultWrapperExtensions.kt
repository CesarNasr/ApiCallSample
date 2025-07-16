package com.eduware.apicallsample.core.network

inline fun <T> ResultWrapper<T>.onSuccess(action: (T) -> Unit): ResultWrapper<T> {
    if (this is ResultWrapper.Success) action(value)
    return this
}

inline fun <T> ResultWrapper<T>.onError(action: (code: Int?, message: String?, type: ErrorType) -> Unit): ResultWrapper<T> {
    if (this is ResultWrapper.GenericError) {
        action(code, message, type)
    }
    return this
}

inline fun <T> ResultWrapper<T>.onNetworkError(action: () -> Unit): ResultWrapper<T> {
    if (this is ResultWrapper.NetworkError) action()
    return this
}
