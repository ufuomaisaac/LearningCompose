package com.example.basiccompose.screens.ArtSpace

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.basiccompose.R

data class ArtDescription(
    @DrawableRes var imageId : Int,
    var artistTitle : String,
    var artworkArtist : String,
    var artworkYear : String,
)

class List {
    var list = listOf<ArtDescription>(
        ArtDescription(imageId = R.drawable.dragon, artistTitle = "Dragon King", artworkArtist = "John Deo", artworkYear = "2001"),
        ArtDescription(imageId = R.drawable.dragon, artistTitle = "Dragon King2", artworkArtist = "John Deo2", artworkYear = "2002"),
        ArtDescription(imageId = R.drawable.dragon, artistTitle = "Dragon King3", artworkArtist = "John Deo3", artworkYear = "2003"),
        ArtDescription(imageId = R.drawable.dragon, artistTitle = "Dragon King", artworkArtist = "John Deo", artworkYear = "2001")
    )
}
