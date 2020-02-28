package com.rastko.emplate_interview.util

import com.rastko.emplate_interview.data.models.PostPeriod
import java.util.*

fun mockPostPeriod(): PostPeriod =
    PostPeriod(
        type = "postperiods",
        id = 54858,
        start = Date(),
        stop = Date(),
        createdAt = Date(),
        updatedAt = Date()
    )

fun mockPostPeriondList(): List<PostPeriod> =
    listOf(mockPostPeriod(), mockPostPeriod(), mockPostPeriod())