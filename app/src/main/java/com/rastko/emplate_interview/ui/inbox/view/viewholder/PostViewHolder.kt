package com.rastko.emplate_interview.ui.inbox.view.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rastko.emplate_interview.R
import com.rastko.emplate_interview.data.models.Posts

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val postName: TextView = itemView.findViewById(R.id.postName)
    private val shopName: TextView = itemView.findViewById(R.id.shopName)
    private val image: ImageView = itemView.findViewById(R.id.image)

    fun bind(post: Posts) {
        postName.text = post.name
        post.thumbnail?.urls?.mobile?.let {
            Glide.with(image).load(it).into(image)
        }
    }
}