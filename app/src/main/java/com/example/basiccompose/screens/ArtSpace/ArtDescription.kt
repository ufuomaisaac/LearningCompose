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
    companion object {
        var list = listOf<ArtDescription>(
        ArtDescription(imageId = R.drawable.dragon, artistTitle = "Still Life of Blue Rose and Other Flowers", artworkArtist = "John Deo", artworkYear = "2001"),
        ArtDescription(imageId = R.drawable.love, artistTitle = "Dragon King in the outer kingdoms", artworkArtist = "John Deo2", artworkYear = "2002"),
        ArtDescription(imageId = R.drawable.message_in_bottle, artistTitle = "Queen's downsided in the Whole Town ", artworkArtist = "John Deo3", artworkYear = "2003"),
        ArtDescription(imageId = R.drawable.light_bulb, artistTitle = "Dragon King4", artworkArtist = "John Deo4", artworkYear = "2004")
    )}

}
