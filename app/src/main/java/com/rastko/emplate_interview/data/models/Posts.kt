package com.rastko.emplate_interview.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class Posts(
    val type: String?,
    val id: Long,
    val name: String?,
    val approved: Boolean,
    val collectible: Boolean,
    val parameters: String?,
    val url: String?,
    @Json(name = "created_at") val createdAt: Date,
    @Json(name = "updated_at") val updatedAt: Date?,
    @Json(name = "deleted_at") val deletedAt: Date?,
    val postFields: List<Postfield>?,
    val postPeriods: List<PostPeriod>?,
    val thumbnail: Thumbnail?
)