package com.zeek1910.exampleproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CommunityActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private val communityAdapter = CommunityAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = communityAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        communityAdapter.setItems(createTestData() + createTestData() + createTestData())
    }

    private fun createTestData(): List<CommunityItem> {
        return listOf(
            CommunityItem(
                profileImageUrl = "https://c.pxhere.com/photos/4a/66/photo-134689.jpg!d",
                name = "John Doe",
                timeAgo = "1 hour ago",
                content = "Hello, this is my first post!Hello, this is my first post!Hello, this is my first post!Hello, this is my first post!Hello, this is my first post!Hello, this is my first post!",
                likeCount = 10,
                commentCount = 5
            ),
            CommunityItem(
                profileImageUrl = "https://img.freepik.com/free-photo/portrait-of-young-woman-with-natural-make-up_23-2149084942.jpg?size=626&ext=jpg&ga=GA1.1.1908636980.1711843200&semt=ais",
                name = "Jane Doe",
                timeAgo = "2 hours ago",
                content = "Hello, this is my second post!",
                likeCount = 20,
                commentCount = 10
            ),
            CommunityItem(
                profileImageUrl = "https://c.pxhere.com/photos/4a/66/photo-134689.jpg!d",
                name = "Alice",
                timeAgo = "3 hours ago",
                content = "Hello, this is my third post!",
                likeCount = 30,
                commentCount = 15
            ),
            CommunityItem(
                profileImageUrl = "https://c.pxhere.com/photos/4a/66/photo-134689.jpg!d",
                name = "Bob",
                timeAgo = "4 hours ago",
                content = "Hello, this is my fourth post!",
                likeCount = 40,
                commentCount = 20
            ),
            CommunityItem(
                profileImageUrl = "https://c.pxhere.com/photos/4a/66/photo-134689.jpg!d",
                name = "Charlie",
                timeAgo = "5 hours ago",
                content = "Hello, this is my fifth post!",
                likeCount = 50,
                commentCount = 25
            )
        )
    }
}