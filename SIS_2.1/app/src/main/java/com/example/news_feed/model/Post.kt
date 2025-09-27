// com.example.newsfeed.model.Post
package com.example.news_feed.model

data class Post(
    val id: Long,
    val text: String,
    val imageUrl: String,
    val isLiked: Boolean = false,
    val likeCount: Int = 0
)
