package com.example.basiccompose.screens.animations

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
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
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextMotion
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


@Composable
fun TextInfiniteAnimation() {
    var infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
    val scale by infiniteTransition.animateFloat(
        initialValue = 2f,
        targetValue = 8f,
        animationSpec = infiniteRepeatable(tween(1000, easing = Easing { 3f * it }, delayMillis = 1000),RepeatMode.Reverse),
        label = "scale"
    )

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black)) {
        Text(
            text = "Hello",
            modifier = Modifier.graphicsLayer {
                scaleX =scale
                scaleY = scale
                transformOrigin = TransformOrigin.Center
            }
                .align(Alignment.Center),
            color = Color.Green,

            style = LocalTextStyle.current.copy(textMotion = TextMotion.Animated)

        )
    }
}


@Preview
@Composable
fun preview() {
    TextInfiniteAnimation()
}


