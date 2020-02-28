package com.rastko.emplate_interview.util

import com.rastko.emplate_interview.data.models.Posts
import java.util.*

fun mockPost(): Posts = Posts(
    type = "posts",
    id = 48177,
    name = "New Snack Range",
    approved = true,
    parameters = "{\\\"Size\\\":[\\\"XS\\\",\\\"S\\\",\\\"M\\\",\\\"L\\\",\\\"XL\\\"]",
    url = "https://emplate.dev/v9/posts/48177.html",
    createdAt = Date(),
    updatedAt = null,
    deletedAt = null,
    collectible = false,
    postPeriods = mockPostPeriondList(),
    postFields = mockPostFieldList(),
    thumbnail = mockThumbnail()
)

fun mockPosts(): List<Posts> = listOf(mockPost(), mockPost(), mockPost(), mockPost(), mockPost())