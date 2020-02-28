package com.rastko.emplate_interview.ui.inbox.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rastko.emplate_interview.R
import com.rastko.emplate_interview.data.models.Posts
import com.rastko.emplate_interview.ui.inbox.view.viewholder.PostViewHolder

class PostAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val posts = mutableListOf<Posts>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        PostViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.post_view_holder,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post = posts[position]
        (holder as PostViewHolder).bind(post)
    }

    fun updatePosts(posts: List<Posts>) {
        this.posts.addAll(posts)
        notifyDataSetChanged()
    }
}