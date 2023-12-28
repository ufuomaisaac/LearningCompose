package com.example.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.collectAsState
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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.basiccompose.screens.ArtSpace.ArtWall
//import com.example.basiccompose.screens.DiceRollerApp
import com.example.basiccompose.screens.motion_layout.profile_header.ProfileHeader
import com.example.basiccompose.screens.motion_layout.profile_header.ProfileHeaderSlot
import com.example.basiccompose.ui.theme.BasicComposeTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(activity = this)
            val viewModel = viewModel<MainViewModel>()
            var counter = viewModel.counterFlow.collectAsState(initial = 50)
            BasicComposeTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colorScheme.onSecondary
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
                    //ProfileHeaderSlot()
                    TimeCounter(counter = counter, modifier = Modifier)
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
