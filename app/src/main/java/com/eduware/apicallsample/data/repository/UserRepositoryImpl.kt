package com.eduware.apicallsample.data.repository

import com.eduware.apicallsample.core.network.ApiResultHandler
import com.eduware.apicallsample.core.network.ResultWrapper
import com.eduware.apicallsample.data.remote.api.UserService
import com.eduware.apicallsample.domain.model.UserResponse
import com.eduware.apicallsample.domain.repository.UserRepository

class UserRepositoryImpl(private val api: UserService) : UserRepository{

    override suspend fun getUserDetails(userId: String): ResultWrapper<UserResponse> {
        return ApiResultHandler.safeApiCall {
            api.getUserDetails(userId)
        }
    }
}
