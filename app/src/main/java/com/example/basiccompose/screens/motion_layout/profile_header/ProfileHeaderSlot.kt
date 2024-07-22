package com.example.basiccompose.screens.motion_layout.profile_header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun ProfileHeaderSlot() {
    var progress by remember {
        mutableStateOf(0f)
    }

    val constraintSet = ConstraintSet {
        val profileHeader = createRefFor("profile_header")
        val slider = createRefFor("slider")

        constrain(profileHeader) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(slider.top, margin = 48.dp)
        }

        constrain(slider) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
    ConstraintLayout(
        constraintSet = constraintSet,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)) {


        ProfileHeader(
            progress = progress,
            modifier = Modifier.layoutId("profile_header"))

        Slider(value = progress,
            onValueChange = { progress = it },
            modifier = Modifier.layoutId("slider")
        )
    }
}
