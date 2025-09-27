package com.example.news_feed.viewmodel

import androidx.lifecycle.*
import com.example.news_feed.model.Post
import com.example.news_feed.data.MockData

class PostsViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    companion object {
        private const val LIKED_IDS_KEY = "liked_ids"
    }

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts

    init {
        // Restore liked IDs from saved state, then apply to mock posts
        val liked = savedStateHandle.get<ArrayList<Long>>(LIKED_IDS_KEY) ?: arrayListOf()
        _posts.value = MockData.getPosts().map { p ->
            if (liked.contains(p.id)) p.copy(isLiked = true, likeCount = p.likeCount + 1) else p
        }
    }

    fun toggleLike(postId: Long) {
        val currentList = _posts.value ?: emptyList()
        val updated = currentList.map { post ->
            if (post.id == postId) {
                post.copy(
                    isLiked = !post.isLiked,
                    likeCount = if (post.isLiked) post.likeCount - 1 else post.likeCount + 1
                )
            } else post
        }
        _posts.value = updated
    }
}
