package com.rastko.emplate_interview.core.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class AppSchedulers(
    val io: Scheduler = Schedulers.io(),
    val ui: Scheduler = AndroidSchedulers.mainThread()
)
