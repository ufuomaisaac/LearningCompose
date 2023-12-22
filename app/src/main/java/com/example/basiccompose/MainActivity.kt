package com.example.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutTagParentData
import androidx.constraintlayout.compose.ConstraintSet
import com.example.basiccompose.screens.ArtSpace.ArtWall
import com.example.basiccompose.screens.BasicLayout.HomeScreen
import com.example.basiccompose.screens.BasicLayout.MySootheApp
//import com.example.basiccompose.screens.ArtSpace.ArtWall
import com.example.basiccompose.screens.ComposeArticle
import com.example.basiccompose.screens.ComposeQuadrant
import com.example.basiccompose.screens.ConstraintLayoutContent
import com.example.basiccompose.screens.DiceRollerApp
import com.example.basiccompose.screens.IndianFlagScreen
//import com.example.basiccompose.screens.DiceRollerApp
import com.example.basiccompose.screens.LemonButtonAndText
import com.example.basiccompose.screens.MyApp
import com.example.basiccompose.screens.ProfileHeader
import com.example.basiccompose.screens.TaskManager
import com.example.basiccompose.screens.TipTimeLayout
import com.example.basiccompose.ui.theme.BasicComposeTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(activity = this)
            BasicComposeTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onSecondary
                ) {
                    // A surface container using the 'background' color from the theme

                    //ComposeArticle()
                    //TaskManager()
                    //ComposeQuadrant()
                    //DiceRollerApp()
                    //TaskManager()
                    //LemonButtonAndText()
                    //TipTimeLayout()
                    //ArtWall()
                    //IndianFlagScreen()
                    //HomeScreen()
                    //MySootheApp(windowSize = windowSizeClass)
                    //onBoardingScreen(onContinueClicked = {})
                    var progress by remember {
                        mutableStateOf(0f)
                    }

                        val constraintSet = ConstraintSet() {
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
            }
        }
    }
}




/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicComposeTheme {

    }
}*/
