package com.rastko.emplate_interview.data.repositories.post

import com.rastko.emplate_interview.data.api.EmplateApi
import com.rastko.emplate_interview.data.models.Posts
import io.reactivex.Single

class PostRepositoryProvider(
    private val api: EmplateApi
) : PostRepository {

    override fun getPosts(): Single<List<Posts>> = api.getPosts()
}