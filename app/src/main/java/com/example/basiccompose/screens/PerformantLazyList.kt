package com.example.basiccompose.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccompose.ui.theme.BasicComposeTheme


@Composable
fun MyApp() {
    var showOnBoardingScreen by remember {
        mutableStateOf(true)
    }

    Surface {
        if(showOnBoardingScreen) {
            onBoardingScreen (onContinueClicked =
            {showOnBoardingScreen = false
            Log.d("12345678", showOnBoardingScreen.toString())})

        } else {
            Greetings()
        }

    }

}

@Composable
private fun Greetings(modifier: Modifier = Modifier,
                  names: List<String> = listOf("Isaac", "Ufuoma", "Jerry")
) {

    Column(modifier = modifier) {
        for (name in names) {
            Greeting(modifier = modifier.fillMaxWidth(),name = name)
        }
    }
}
@Composable
private fun Greeting(modifier: Modifier, name: String) {
    var expanded by remember {
        mutableStateOf(false)
    }

    val extraPadding = if (expanded) 48.dp else 0.dp

    Surface(color = MaterialTheme.colorScheme.primary,
            modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {

        Row(modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
            .padding(bottom = extraPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Column(modifier = Modifier
                .weight(1f)) {

                Text(text = "Hello")
                Text(text = "$name!")
            }


            ElevatedButton(
                onClick = { expanded = !expanded })
            {
                Text( if(expanded)  "Show more" else "Show less")
            }
        }

    }
}

@Composable
fun onBoardingScreen(modifier: Modifier = Modifier,
                     onContinueClicked: () -> Unit,
                     ) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome to the Basics Codelabs!")
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick =  onContinueClicked
            ) {
            Text(text = "Continue")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicComposeTheme {
        //MyApp(modifier = Modifier.fillMaxWidth())
        onBoardingScreen(modifier = Modifier.fillMaxSize(),
            onContinueClicked =  {})
    }
}

