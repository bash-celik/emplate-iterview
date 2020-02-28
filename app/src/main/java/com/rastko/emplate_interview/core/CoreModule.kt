package com.rastko.emplate_interview.core

import com.rastko.emplate_interview.core.rx.AppSchedulers
import org.koin.dsl.module

val coreModule = module {
    single { AppSchedulers() }

}