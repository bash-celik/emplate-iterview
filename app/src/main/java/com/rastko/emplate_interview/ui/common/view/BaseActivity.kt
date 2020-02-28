package com.rastko.emplate_interview.ui.common.view

import androidx.appcompat.app.AppCompatActivity
import com.rastko.emplate_interview.ui.common.event.ViewEvent
import io.reactivex.subjects.PublishSubject

open class BaseActivity : AppCompatActivity() {
    protected val viewEvents: PublishSubject<ViewEvent> = PublishSubject.create()

}