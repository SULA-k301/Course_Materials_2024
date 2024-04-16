package com.zeek1910.exampleproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zeek1910.exampleproject.models.CommunityItem

class CommunityAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<CommunityItem>()

    fun setItems(items: List<CommunityItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].likeCount > 0) {
            TYPE_LIKE
        } else {
            TYPE_UNLIKE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        return when(viewType){
            TYPE_LIKE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_community, parent, false)
                CommunityViewHolder(view)
            }

            TYPE_UNLIKE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_community_unliked, parent, false)
                UnlikeCommunityViewHolder(view)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            TYPE_LIKE -> {
                (holder as CommunityViewHolder).bind(items[position])
            }
            TYPE_UNLIKE -> {
                (holder as UnlikeCommunityViewHolder).bind(items[position])
            }
        }
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

    class UnlikeCommunityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val profileImage: ImageView = itemView.findViewById(R.id.profileImage)
        private val profileName: TextView = itemView.findViewById(R.id.profileName)
        private val timeAgo: TextView = itemView.findViewById(R.id.timeAgo)
        private val content: TextView = itemView.findViewById(R.id.content)
        fun bind(item: CommunityItem) {
            Glide.with(itemView)
                .load(item.profileImageUrl)
                .circleCrop()
                .into(profileImage)
            profileName.text = item.name
            timeAgo.text = item.timeAgo
            content.text = item.content
        }
    }

    companion object{
        private const val TYPE_LIKE = 1
        private const val TYPE_UNLIKE = 2
    }
}