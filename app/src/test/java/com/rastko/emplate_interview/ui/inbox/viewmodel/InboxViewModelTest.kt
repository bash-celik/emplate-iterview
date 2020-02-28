package com.rastko.emplate_interview.ui.inbox.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.rastko.emplate_interview.core.rx.MockAppSchedulers
import com.rastko.emplate_interview.data.repositories.post.PostRepository
import com.rastko.emplate_interview.ui.common.event.ViewEvent
import com.rastko.emplate_interview.ui.common.state.ViewModelState
import com.rastko.emplate_interview.ui.inbox.events.LoadPostsViewEvent
import com.rastko.emplate_interview.ui.inbox.state.InboxViewState
import com.rastko.emplate_interview.util.mockPosts
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verifySequence
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class InboxViewModelTest {
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val postRepository: PostRepository = mockk(relaxed = true)
    private val schedulers = MockAppSchedulers()
    private lateinit var viewModel: InboxViewModel

    private val observer: Observer<ViewModelState> = spyk()
    private val viewEvents: PublishSubject<ViewEvent> = PublishSubject.create()

    private val response = mockPosts()

    @Before
    fun setup() {
        viewModel = InboxViewModel(postRepository, schedulers)
        viewModel.viewState.observeForever(observer)
        viewModel.setupViewEvents(viewEvents)
    }

    @Test
    fun `test load posts and set state success`() {
        // given
        `when requesting posts return response`()

        // when
        viewEvents.onNext(LoadPostsViewEvent)

        // then
        verifySequence {
            observer.onChanged(InboxViewState.ShowLoadingState)
            observer.onChanged(InboxViewState.HideLoadingState)
            observer.onChanged(InboxViewState.PostsLoadedState(response))

        }

    }

    @Test
    fun `test load posts and set state fail`() {
        // given
        `when requesting posts return error`()

        // when
        viewEvents.onNext(LoadPostsViewEvent)

        // then
        verifySequence {
            observer.onChanged(InboxViewState.ShowLoadingState)
            observer.onChanged(InboxViewState.HideLoadingState)

        }
    }

    private fun `when requesting posts return response`() {
        every { postRepository.getPosts() } returns Single.just(response)
    }

    private fun `when requesting posts return error`() {
        every { postRepository.getPosts() } returns Single.error(Throwable("an error ocured"))
    }

}