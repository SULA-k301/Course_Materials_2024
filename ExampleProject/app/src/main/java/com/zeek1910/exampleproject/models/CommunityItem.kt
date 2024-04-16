package com.zeek1910.exampleproject.models

data class CommunityItem(
    val profileImageUrl: String,
    val name: String,
    val timeAgo: String,
    val content: String,
    val likeCount: Int,
    val commentCount: Int
)
