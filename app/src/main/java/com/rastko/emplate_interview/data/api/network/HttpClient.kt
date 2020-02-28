package com.rastko.emplate_interview.data.api.network

import com.rastko.emplate_interview.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

private const val CONNECT_TIMEOUT = 30L
private const val READ_TIMEOUT = 15L
private const val WRITE_TIMEOUT = 15L

internal fun createOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .addLoggingIfConfigured(BuildConfig.DEBUG)
    .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
    .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
    .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
    .build()

private fun OkHttpClient.Builder.addLoggingIfConfigured(isDebug: Boolean): OkHttpClient.Builder =
    if (isDebug) {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        addInterceptor(httpLoggingInterceptor)
    } else this
