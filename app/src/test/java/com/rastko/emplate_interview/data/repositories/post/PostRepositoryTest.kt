package com.rastko.emplate_interview.data.repositories.post

import com.rastko.emplate_interview.core.rx.MockAppSchedulers
import com.rastko.emplate_interview.data.api.EmplateApi
import com.rastko.emplate_interview.util.mockPosts
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import org.amshove.kluent.`should be equal to`
import org.junit.Before
import org.junit.Test


class PostRepositoryTest {
    private val schedulers = MockAppSchedulers()
    private val api: EmplateApi = mockk(relaxed = true)
    private lateinit var postRepo: PostRepository

    private val response = mockPosts()

    @Before
    fun setup() {
        postRepo = PostRepositoryProvider(api)

    }

    @Test
    fun `test get posts from remote success`() {
        // given
        `when requesting posts api returns response`()

        // when
        val posts = postRepo.getPosts().blockingGet()

        // then
        posts[0].id `should be equal to` response[0].id

    }

    @Test(expected = Throwable::class)
    fun `test get post from remote fail`() {
        // given
        `when requesting posts api returns error`()

        // when
        postRepo.getPosts().blockingGet()

        // then
    }

    private fun `when requesting posts api returns response`() {
        every { api.getPosts() } returns Single.just(response)
    }

    private fun `when requesting posts api returns error`() {
        every { api.getPosts() } returns Single.error(Throwable("And error occured"))
    }

}