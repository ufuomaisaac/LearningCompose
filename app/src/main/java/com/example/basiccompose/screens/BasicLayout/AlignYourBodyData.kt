package com.example.basiccompose.screens.BasicLayout

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class AlignYourBodyData(
    @DrawableRes var imageId: Int,
    @StringRes var textId: Int
)

data class Favouritecard(
    @DrawableRes var imageId: Int,
    @StringRes var textId: Int
)
