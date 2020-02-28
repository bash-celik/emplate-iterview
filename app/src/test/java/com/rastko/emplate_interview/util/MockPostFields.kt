package com.rastko.emplate_interview.util

import com.rastko.emplate_interview.data.models.Postfield
import java.util.*

fun mockPostFields(): Postfield =
    Postfield(
        type = "postfields",
        id = 55140,
        postId = 48173,
        postFieldTypeId = 6,
        order = 0,
        content = "{\"images\":[76103],\"redeemable\":false,\"text\":\"NEW, JUICY AND HEALTHY!!! If this is what you\'re looking for in your Sub, wrap or salad; Then our breaded chicken is our choice for you!\\n\\n#SubwayMalta #Subway #NewProduct #MyWay\"}",
        createdAt = Date(),
        updatedAt = null
    )

fun mockPostFieldList(): List<Postfield> = listOf(mockPostFields(),mockPostFields(), mockPostFields())