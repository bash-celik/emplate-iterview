package com.rastko.emplate_interview.util

import com.rastko.emplate_interview.data.models.Thumbnail

fun mockThumbnail(): Thumbnail = Thumbnail(
    type = "media",
    id = 76103,
    name = null,
    filetype = "jpeg",
    width = 279,
    height = 279,
    urls = mockUrls()
)