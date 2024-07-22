
package com.example.basiccompose.screens.basic_layout.navigation_screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.basiccompose.R
import com.example.basiccompose.ui.theme.BasicComposeTheme

@Composable
fun DiceRollerApp(){
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DiceWithImageandButton(modifier = Modifier)
    }
}

@Composable
fun DiceWithImageandButton(modifier : Modifier = Modifier){
    var imageResourceId by remember { mutableStateOf(R.drawable.dice_1) }
    var result by remember {
        mutableStateOf(1)
    }

    Column(
        modifier = modifier, 
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(painter = painterResource(imageResourceId), contentDescription = result.toString() )
        Button(onClick = { result = (Math.random() * 6).toInt() + 1
            Log.d("AAAA", result.toString())
        when(result) {
            1 -> imageResourceId = R.drawable.dice_1
            2 -> imageResourceId = R.drawable.dice_2
            3 -> imageResourceId = R.drawable.dice_3
            4 -> imageResourceId = R.drawable.dice_4
            5 -> imageResourceId = R.drawable.dice_5
            6 -> imageResourceId = R.drawable.dice_6
            else -> R.drawable.dice_5
        }
        }) {
            Text(text = "Roll")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    BasicComposeTheme {
        DiceRollerApp()
    }
}
