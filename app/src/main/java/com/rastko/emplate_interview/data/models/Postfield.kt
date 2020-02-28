package com.rastko.emplate_interview.data.models

import com.squareup.moshi.Json
import java.util.*

data class Postfield(
    val type: String?,
    val id: Long,
    @Json(name = "post_id") val postId: Long,
    @Json(name = "postFieldType_id") val postFieldTypeId: Int,
    val order: Int,
    val content: String,
    @Json(name = "created_at") val createdAt: Date,
    @Json(name = "updated_at") val updatedAt: Date?
)