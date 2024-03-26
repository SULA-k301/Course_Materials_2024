package com.zeek1910.exampleproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnboardingAdapter : RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    private val items = listOf(
        OnboardingItem(
            titleResId = R.string.onboarding_1_title,
            imageResId = R.drawable.onboarding_image_1,
            subTitleResId = R.string.onboarding_1_sub_title
        ),
        OnboardingItem(
            titleResId = R.string.onboarding_2_title,
            imageResId = R.drawable.onboarding_image_2,
            subTitleResId = R.string.onboarding_2_sub_title
        ),
        OnboardingItem(
            titleResId = R.string.onboarding_3_title,
            imageResId = R.drawable.onboarding_image_3,
            subTitleResId = R.string.onboarding_3_sub_title
        ),
        OnboardingItem(
            titleResId = R.string.onboarding_4_title,
            imageResId = R.drawable.onboarding_image_4,
            subTitleResId = R.string.onboarding_4_sub_title
        )
    )

    class OnboardingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.title)
        private val subTitle = itemView.findViewById<TextView>(R.id.subTitle)
        private val image = itemView.findViewById<ImageView>(R.id.image)

        fun bind(item: OnboardingItem) {
            title.setText(item.titleResId)
            subTitle.setText(item.subTitleResId)
            image.setImageResource(item.imageResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = OnboardingViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_onboarding, parent, false)
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bind(items[position])
    }
}