package com.rastko.emplate_interview.ui.inbox.state

import com.rastko.emplate_interview.data.models.Posts
import com.rastko.emplate_interview.ui.common.state.ViewModelState

sealed class InboxViewState : ViewModelState {
    object ShowLoadingState : InboxViewState()
    object HideLoadingState : InboxViewState()
    data class PostsLoadedState(val posts: List<Posts>) : InboxViewState()
}