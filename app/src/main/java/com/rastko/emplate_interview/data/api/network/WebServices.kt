package com.rastko.emplate_interview.data.api.network

import com.rastko.emplate_interview.data.api.EmplateApi
import retrofit2.Retrofit

internal fun createWebService(retrofit: Retrofit): EmplateApi {
    return retrofit.create(EmplateApi::class.java)
}
