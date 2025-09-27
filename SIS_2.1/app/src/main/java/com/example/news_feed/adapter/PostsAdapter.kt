package com.example.news_feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.news_feed.R
import com.example.news_feed.databinding.ActivityMainBinding
import com.example.news_feed.databinding.ItemPostBinding
import com.example.news_feed.model.Post

class PostsAdapter(
    private val onLikeClicked: (postId: Long) -> Unit
) : ListAdapter<Post, PostsAdapter.PostViewHolder>(DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PostViewHolder(private val b: ItemPostBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(post: Post) {
            b.tvText.text = post.text
            b.ivImage.load(post.imageUrl) { crossfade(true) }

            if (post.isLiked) {
                b.btnLike.setImageResource(R.drawable.ic_like_filled)
                b.btnLike.setColorFilter(
                    b.root.context.getColor(android.R.color.holo_red_dark)
                )
            } else {
                b.btnLike.setImageResource(R.drawable.ic_like_outline)
                b.btnLike.setColorFilter(
                    b.root.context.getColor(android.R.color.darker_gray)
                )
            }

            b.tvLikeCount.text = post.likeCount.toString()

            b.btnLike.setOnClickListener {
                onLikeClicked(post.id)
            }
        }
    }

    companion object {
        val DIFF = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Post, newItem: Post) = oldItem == newItem
        }
    }
}





