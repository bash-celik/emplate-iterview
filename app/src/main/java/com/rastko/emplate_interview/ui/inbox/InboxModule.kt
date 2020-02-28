package com.rastko.emplate_interview.ui.inbox

import com.rastko.emplate_interview.ui.inbox.viewmodel.InboxViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val indexModule = module {
    viewModel { InboxViewModel(repositoryProvider = get(), schedulers = get()) }
}