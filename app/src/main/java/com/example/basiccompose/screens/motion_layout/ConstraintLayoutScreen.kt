package com.example.basiccompose.screens.motion_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.basiccompose.ui.theme.BasicComposeTheme

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout(modifier = Modifier) {
        // Create references for the composables to constrain
        val (button, text, progressbar, buttonn) = createRefs()

        Button(
            onClick = { /* Do something */ },
            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text("Button")
        }

        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text(
            "Text",
            Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = 16.dp)
            }
        )
        LinearProgressIndicator(
            progress = 1.00f,
            modifier = Modifier
                .height(10.dp)
                .constrainAs(progressbar) {
                    start.linkTo(text.end, margin = 8.dp)
                    top.linkTo(text.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(text.bottom)
                }
        )

        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .constrainAs(buttonn) {
                    start.linkTo(progressbar.start)
                    top.linkTo(progressbar.bottom, margin = 8.dp)
                    end.linkTo(progressbar.end)

                }) {

        }

    }
}

@Composable
fun IndianFlagScreen() {
    val constraints = ConstraintSet {
        val orangeBox = createRefFor("orangebox")
        val greenBox = createRefFor("greenbox")
        val circle = createRefFor("circle")
        val whiteBox = createRefFor("whitebox")

        constrain(orangeBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(circle.top)
            width = Dimension.fillToConstraints
            height = Dimension.value(260.dp)
        }
        constrain(circle) {
            top.linkTo(orangeBox.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(greenBox) {
            top.linkTo(circle.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(260.dp)
        }
        constrain(whiteBox) {
            top.linkTo(greenBox.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            width = Dimension.fillToConstraints
            height = Dimension.value(400.dp)
        }
        createVerticalChain(orangeBox, circle, greenBox, chainStyle = ChainStyle.SpreadInside)
    }
    ConstraintLayout(constraints, modifier = Modifier
        .background(Color.White)
        .fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(Color(0xFFFB8C00))
                .layoutId("orangebox")
        )
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.Blue)
                .layoutId("circle")
        )
        Box(
            modifier = Modifier
                .background(Color(0xFF2EB734))
                .layoutId("greenbox")
        )
    }
}

@Composable
fun NigeriaFlag(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (greenbox1, whitebox, greenbox2) = createRefs()

        Box(modifier = Modifier
            .background(Color.Green)
            .constrainAs(greenbox1) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        )

        Box(modifier = Modifier
            .background(Color.White)
            .constrainAs(whitebox) {
                top.linkTo(greenbox1.bottom)
                bottom.linkTo(greenbox2.top)
                start.linkTo(parent.start)
                end.linkTo((parent.end))
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            })

        Box(modifier = modifier
            .background(Color.Green)
            .constrainAs(greenbox2) {
                top.linkTo(whitebox.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            })
        createVerticalChain(greenbox1, whitebox, greenbox2, chainStyle = ChainStyle.SpreadInside)
    }
}


@Preview
@Composable
fun ConstraintLayoutpreview() {
    BasicComposeTheme {
        NigeriaFlag(modifier = Modifier)
    }
}


