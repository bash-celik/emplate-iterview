package com.rastko.emplate_interview.core.rx

import io.reactivex.schedulers.Schedulers

class MockAppSchedulers : AppSchedulers(Schedulers.trampoline(), Schedulers.trampoline())
