package com.example.newsfeed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newsfeed.databinding.ItemPostBinding
import com.example.newsfeed.model.Post

class PostsAdapterImageOnly(private val items: List<Post>) :
    RecyclerView.Adapter<PostsAdapterImageOnly.VH>() {

    inner class VH(private val b: ItemPostBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(item: Post) {
            b.ivImage.load(item.imageUrl) {
                crossfade(true)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val b = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(b)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
