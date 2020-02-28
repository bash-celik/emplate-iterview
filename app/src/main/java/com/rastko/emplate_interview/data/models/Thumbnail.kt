package com.rastko.emplate_interview.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Thumbnail(
    val type: String?,
    val id: Long,
    val name: String?,
    val filetype: String?,
    val width: Int,
    val height: Int,
    val urls: Urls
)