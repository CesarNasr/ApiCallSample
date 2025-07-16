package com.eduware.apicallsample.domain.model

data class Envelope<T>(
    val status: Boolean,
    val message: String?,
    val data: T?
)