package com.example.newsfeed.data

import com.example.newsfeed.model.Post

object MockData {
    // Use picsum.photos for stable random images
    val postsSimple = listOf(
        Post(1, "https://picsum.photos/seed/1/800/500"),
        Post(2, "https://picsum.photos/seed/2/800/500"),
        Post(3, "https://picsum.photos/seed/3/800/500"),
        Post(4, "https://picsum.photos/seed/4/800/500"),
        Post(5, "https://picsum.photos/seed/5/800/500"),
        Post(6, "https://picsum.photos/seed/6/800/500")
    )
}
