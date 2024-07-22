package com.example.basiccompose.screens.animations

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Interaction() {

    var mutableInteractionSource = remember {
        MutableInteractionSource()
    }

    var pressed = mutableInteractionSource.collectIsPressedAsState()
    val animatedAlpha by animateFloatAsState(
        targetValue = if (pressed.value) 1.0f else 0f,
        label = "alpha"
    )
    Box(
        modifier = Modifier
            .size(200.dp)
            .graphicsLayer {
                alpha = animatedAlpha
            }
            .clip(RoundedCornerShape(8.dp))
            .padding(16.dp)
            .background(Color.Green)
            .clickable(mutableInteractionSource, indication = null, enabled = true, onClick = {})

    ) {
    }
}

@Preview
@Composable
fun preview() {
    Interaction()
}