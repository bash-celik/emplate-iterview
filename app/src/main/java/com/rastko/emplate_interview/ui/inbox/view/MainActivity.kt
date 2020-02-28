package com.rastko.emplate_interview.ui.inbox.view

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rastko.emplate_interview.R
import com.rastko.emplate_interview.core.extentions.observeNotNull
import com.rastko.emplate_interview.data.models.Posts
import com.rastko.emplate_interview.ui.common.view.BaseActivity
import com.rastko.emplate_interview.ui.inbox.events.LoadPostsViewEvent
import com.rastko.emplate_interview.ui.inbox.state.InboxViewState
import com.rastko.emplate_interview.ui.inbox.view.adapter.PostAdapter
import com.rastko.emplate_interview.ui.inbox.viewmodel.InboxViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : BaseActivity() {
    private val inboxViewModel: InboxViewModel by viewModel()
    private val adapter: PostAdapter by lazy { PostAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inboxViewModel.setupViewEvents(viewEvents)

        inboxViewModel.viewState.observeNotNull(this) {
            when (it) {
                is InboxViewState.HideLoadingState -> hideLoading()
                is InboxViewState.ShowLoadingState -> showLoading()
                is InboxViewState.PostsLoadedState -> showPosts(it.posts)

            }
        }

        viewEvents.onNext(LoadPostsViewEvent)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

    }

    private fun hideLoading() {
        // hide loading
    }

    private fun showLoading() {
        // show loading
    }

    private fun showPosts(posts: List<Posts>) {
        //  show posts
        Timber.d("data loaded $posts")
        adapter.updatePosts(posts)

    }
}
