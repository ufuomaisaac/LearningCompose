package com.example.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basiccompose.screens.ArtSpace.ArtWall
//import com.example.basiccompose.screens.ArtSpace.ArtWall
import com.example.basiccompose.screens.ComposeArticle
import com.example.basiccompose.screens.ComposeQuadrant
import com.example.basiccompose.screens.DiceRollerApp
//import com.example.basiccompose.screens.DiceRollerApp
import com.example.basiccompose.screens.LemonButtonAndText
import com.example.basiccompose.screens.MyApp
import com.example.basiccompose.screens.TaskManager
import com.example.basiccompose.screens.TipTimeLayout
import com.example.basiccompose.ui.theme.BasicComposeTheme
import com.example.basiccompose.ui.theme.Grey

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
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
                    MyApp(modifier = Modifier)
                    //onBoardingScreen(onContinueClicked = {})
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
