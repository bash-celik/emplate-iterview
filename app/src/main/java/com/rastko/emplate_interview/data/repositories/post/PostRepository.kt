package com.rastko.emplate_interview.data.repositories.post

import com.rastko.emplate_interview.data.models.Posts
import io.reactivex.Single

interface PostRepository {
    fun getPosts(): Single<List<Posts>>

}