package com.rastko.emplate_interview.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Urls(val original: String, val large: String, val mobile: String, val thumbnail: String)