package com.example.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basiccompose.screens.time_counter.MainViewModel
//import com.example.basiccompose.screens.ArtSpace.ArtWall
//import com.example.basiccompose.screens.DiceRollerApp
import com.example.basiccompose.screens.time_counter.TimeCounter
import com.example.basiccompose.ui.theme.BasicComposeTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(activity = this)
            val viewModel = viewModel<MainViewModel>()
            var counter = viewModel.counterFlow.collectAsState(initial = 50)
            BasicComposeTheme {
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
