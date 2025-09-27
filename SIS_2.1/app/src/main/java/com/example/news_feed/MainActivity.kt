package com.example.news_feed

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.news_feed.databinding.ActivityMainBinding
import com.example.news_feed.adapter.PostsAdapter
import com.example.news_feed.viewmodel.PostsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: PostsViewModel by viewModels() // SavedStateHandle injected automatically

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PostsAdapter { postId ->
            viewModel.toggleLike(postId)
        }
        binding.rvPosts.adapter = adapter

        viewModel.posts.observe(this) { posts ->
            adapter.submitList(posts)
        }
    }
}
