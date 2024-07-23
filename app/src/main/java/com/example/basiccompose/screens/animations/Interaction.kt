package com.example.basiccompose.screens.animations

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

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

@Composable
fun Displacement() {

    var moved by remember { mutableStateOf(false)}
    val  pxToMove = with(LocalDensity.current) {
        100.dp.toPx().roundToInt()
    }

    val offset by animateIntOffsetAsState(
        targetValue = if (moved) {
            IntOffset(pxToMove, pxToMove)
        } else {
            IntOffset(50, 50)
        },
        label = "offset"
    )

    Box(modifier = Modifier.
            offset{
                offset
            }
        .background(Color.Blue)
        .size(100.dp)
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) {
            moved = !moved
        } )

}



@Composable
fun PaddingAnItem() {
    var toggle by remember {
        mutableStateOf(false)
    }

    val animatePadding by animateDpAsState(
        targetValue = if (toggle) {
            0.dp
        } else
            20.dp,
        label = "padding"
    )

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxSize()
            .padding(animatePadding)
            .background(Color.Red)
            .clickable (
                interactionSource = remember { MutableInteractionSource()},
                indication = null,
                onClick = {toggle = !toggle}
            )
    )
}


@Preview
@Composable
fun preview() {
    PaddingAnItem()
}


