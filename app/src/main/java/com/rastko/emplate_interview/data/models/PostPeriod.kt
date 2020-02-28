package com.rastko.emplate_interview.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class PostPeriod(
    val type: String,
    val id: Long,
    val start: Date,
    val stop: Date,
    @Json(name = "created_at") val createdAt: Date,
    @Json(name = "updated_at") val updatedAt: Date?
)