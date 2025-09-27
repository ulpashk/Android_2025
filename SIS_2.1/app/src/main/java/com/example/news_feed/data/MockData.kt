// com.example.news_feed.data.MockData.kt
package com.example.news_feed.data

import com.example.news_feed.model.Post

object MockData {
    fun getPosts(): List<Post> {
        return listOf(
            Post(1, "Morning coffee and headlines", "https://picsum.photos/seed/1/800/500", false, 4),
            Post(2, "Cityscape from the rooftop", "https://picsum.photos/seed/2/800/500", false, 2),
            Post(3, "A quick coding tip", "https://picsum.photos/seed/3/800/500", false, 7),
            Post(4, "Nature walk highlights", "https://picsum.photos/seed/4/800/500", false, 1),
            Post(5, "Late night thoughts", "https://picsum.photos/seed/5/800/500", false, 0),
            Post(6, "Morning", "https://picsum.photos/seed/6/800/500", false, 0),
            Post(7, "Afternoon", "https://picsum.photos/seed/7/800/500", false, 0),
            Post(8, "Evening", "https://picsum.photos/seed/8/800/500", false, 0),
            Post(9, "Night", "https://picsum.photos/seed/9/800/500", false, 0)
        )
    }
}
