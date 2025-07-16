package com.eduware.apicallsample.core.network

import com.eduware.apicallsample.domain.model.Envelope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ApiResultHandler {
    suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        apiCall: suspend () -> Response<Envelope<T>>
    ): ResultWrapper<T> {

        return withContext(dispatcher) {
            try {
                val response = apiCall()

                if (!response.isSuccessful) {
                    return@withContext genericError(
                        response.code(),
                        response.message(),
                        getErrorType(response)
                    )
                }

                val envelope = response.body()
                if (envelope != null) {
                    if (envelope.status && envelope.data != null) {
                        ResultWrapper.Success(envelope.data)
                    } else {
                        genericError(response.code(), envelope.message ?: "Unknown error")
                    }
                } else {
                    genericError(response.code(), "Null envelope")
                }
            } catch (e: IOException) {
                ResultWrapper.NetworkError
            } catch (e: HttpException) {
                genericError(e.code(), e.message())
            } catch (e: Exception) {
                genericError(null, e.localizedMessage ?: "Unexpected error")
            }
        }


    }

    private fun <T> getErrorType(response: Response<Envelope<T>>): ErrorType =
        when (response.code()) {
            400 -> ErrorType.BAD_REQUEST
            401 -> ErrorType.UNAUTHORIZED
            403 -> ErrorType.FORBIDDEN
            404 -> ErrorType.NOT_FOUND
            in 500..599 -> ErrorType.SERVER_ERROR
            else -> ErrorType.UNKNOWN
        }

    fun genericError(code: Int?, message: String, type: ErrorType = ErrorType.UNKNOWN) =
        ResultWrapper.GenericError(
            code = code,
            message = message,
            type = type
        )


}
