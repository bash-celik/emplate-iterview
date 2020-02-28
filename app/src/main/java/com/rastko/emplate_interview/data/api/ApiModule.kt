package com.rastko.emplate_interview.data.api

import com.rastko.emplate_interview.data.api.network.*
import org.koin.dsl.module

val apiModule = module {
    single(definition = { createOkHttpClient() })

    single(definition = { createMoshi() })

    single(definition = {
        createJsonConverter(
            moshi = get()
        )
    })

    single(definition = {
        createRetrofit(
            okHttpClient = get(),
            converter = get()
        )
    })

    single { createWebService(retrofit = get()) }
}