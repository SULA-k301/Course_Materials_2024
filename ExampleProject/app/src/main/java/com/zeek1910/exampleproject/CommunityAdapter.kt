package com.zeek1910.exampleproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CommunityAdapter: RecyclerView.Adapter<CommunityAdapter.CommunityViewHolder>() {

    private val items = mutableListOf<CommunityItem>()

    fun setItems(items: List<CommunityItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CommunityViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_community, parent, false)
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CommunityViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class CommunityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val profileImage: ImageView = itemView.findViewById(R.id.profileImage)
        private val profileName: TextView = itemView.findViewById(R.id.profileName)
        private val timeAgo: TextView = itemView.findViewById(R.id.timeAgo)
        private val content: TextView = itemView.findViewById(R.id.content)
        private val likeCount: TextView = itemView.findViewById(R.id.likeCount)
        private val commentCount: TextView = itemView.findViewById(R.id.commentCount)
        fun bind(item: CommunityItem) {
            Glide.with(itemView)
                .load(item.profileImageUrl)
                .circleCrop()
                .into(profileImage)
            profileName.text = item.name
            timeAgo.text = item.timeAgo
            content.text = item.content
            likeCount.text = item.likeCount.toString()
            commentCount.text = item.commentCount.toString()
        }
    }
}