package com.rastko.emplate_interview.data.repositories.post

import org.koin.dsl.module

val postModule = module {
    single<PostRepository> { PostRepositoryProvider(api = get()) }
}