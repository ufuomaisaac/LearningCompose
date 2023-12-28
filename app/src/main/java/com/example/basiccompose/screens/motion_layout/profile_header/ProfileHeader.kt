package com.example.basiccompose.screens.motion_layout.profile_header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.example.basiccompose.R
import com.example.basiccompose.ui.theme.BasicComposeTheme

@OptIn(ExperimentalMotionApi::class)
@Composable
fun ProfileHeader(progress : Float, modifier: Modifier) {
    val context = LocalContext.current
    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.motion_scen)
            .readBytes()
            .decodeToString()
    }
    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .layoutId("box"))

       Image(painter = painterResource(id = R.drawable.ab1_inversions),
           contentDescription = "profile_picture",
           modifier = Modifier
               .layoutId("profile_pic")
               .clip(CircleShape)
               .border(
                   width = 2.dp,
                   color = Color.Green,
                   shape = CircleShape
               ))

        Text(text = "Ufuoma Isaac",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.layoutId("username"))

    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview11() {
    BasicComposeTheme {
       // ProfileHeader(progress = 1f)
        // Greetings()
    }
}