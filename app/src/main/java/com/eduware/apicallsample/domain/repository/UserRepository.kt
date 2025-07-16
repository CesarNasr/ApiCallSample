package com.eduware.apicallsample.domain.repository

import com.eduware.apicallsample.core.network.ResultWrapper
import com.eduware.apicallsample.domain.model.UserResponse

interface UserRepository {
    suspend fun getUserDetails(userId: String): ResultWrapper<UserResponse>
}