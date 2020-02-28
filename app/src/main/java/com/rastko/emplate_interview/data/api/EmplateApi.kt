package com.rastko.emplate_interview.data.api

import com.rastko.emplate_interview.BuildConfig
import com.rastko.emplate_interview.data.models.Posts
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface EmplateApi {

    @GET("posts")
    fun getPosts(
        @Query("include") include: List<String> = listOf(
            "postfields",
            "postperiods",
            "thumbnail"
        ),
        @Header("X-Api-Key") apiKey: String = BuildConfig.API_KEY
    ): Single<List<Posts>>

}