package com.zeek1910.exampleproject

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnboardingItem(
    @StringRes val titleResId: Int,
    @DrawableRes val imageResId: Int,
    @StringRes val subTitleResId: Int
)
