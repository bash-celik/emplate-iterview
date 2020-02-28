package com.rastko.emplate_interview.ui.inbox.viewmodel

import com.rastko.emplate_interview.core.rx.AppSchedulers
import com.rastko.emplate_interview.data.models.Posts
import com.rastko.emplate_interview.data.repositories.post.PostRepository
import com.rastko.emplate_interview.ui.common.event.ViewEvent
import com.rastko.emplate_interview.ui.common.viewmodel.BaseViewModel
import com.rastko.emplate_interview.ui.inbox.events.LoadPostsViewEvent
import com.rastko.emplate_interview.ui.inbox.state.InboxViewState
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.ofType
import timber.log.Timber

class InboxViewModel(
    private val repositoryProvider: PostRepository,
    private val schedulers: AppSchedulers
) : BaseViewModel() {

    private val posts = mutableListOf<Posts>()

    override fun setupViewEvents(viewEvents: Observable<ViewEvent>) {
        super.setupViewEvents(viewEvents)
        addAll(
            registerLoadPostsDisposable(viewEvents)
        )
    }

    private fun registerLoadPostsDisposable(viewEvents: Observable<ViewEvent>): Disposable =
        viewEvents.ofType<LoadPostsViewEvent>()
            .doOnNext { updateState(InboxViewState.ShowLoadingState) }
            .flatMapSingle {
                repositoryProvider.getPosts().subscribeOn(schedulers.io)
            }
            .map { updatePosts(it) }
            .doOnError { updateState(InboxViewState.HideLoadingState) }
            .observeOn(schedulers.ui)
            .subscribe(
                { notifyPostsLoaded() },
                { Timber.e(it, "error while loading posts") }
            )

    private fun updatePosts(newPosts: List<Posts>) {
        posts.clear()
        posts.addAll(newPosts)
    }

    private fun notifyPostsLoaded() {
        updateState(InboxViewState.HideLoadingState)
        updateState(InboxViewState.PostsLoadedState(posts))
    }
}