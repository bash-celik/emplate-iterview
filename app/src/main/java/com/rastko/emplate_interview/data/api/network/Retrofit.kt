package com.rastko.emplate_interview.data.api.network

import com.rastko.emplate_interview.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

fun createRetrofit(
    okHttpClient: OkHttpClient,
    converter: Converter.Factory
): Retrofit = Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(converter)
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()
