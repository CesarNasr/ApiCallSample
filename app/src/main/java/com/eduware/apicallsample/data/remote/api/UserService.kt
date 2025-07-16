package com.eduware.apicallsample.data.remote.api

import com.eduware.apicallsample.domain.model.Envelope
import com.eduware.apicallsample.domain.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("users/{id}")
    suspend fun getUserDetails(@Path("id") id: String):Response<Envelope<UserResponse>>
}