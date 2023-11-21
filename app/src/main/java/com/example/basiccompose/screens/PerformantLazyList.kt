package com.example.basiccompose.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccompose.R
import com.example.basiccompose.ui.theme.BasicComposeTheme


@Composable
fun MyApp(modifier: Modifier) {
    var showOnBoardingScreen by remember {
        mutableStateOf(true)
    }

    Surface {
        if(showOnBoardingScreen) {
            onBoardingScreen (modifier = modifier, onContinueClicked =
            {showOnBoardingScreen = false })

        } else {
            Greetings()
        }
    }
}

@Composable
private fun Greetings(modifier: Modifier = Modifier,
                      names: List<String> = List(1000) {"$it"}

) {
    
    LazyColumn(modifier = modifier) {
        items(items = names) { name ->
            CardContent(name = name)
        }
    }
}

@Composable
fun CardContent(modifier: Modifier = Modifier, name: String ) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.error,
            disabledContainerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.background,
            disabledContentColor = MaterialTheme.colorScheme.tertiary
        ),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        elevation = CardDefaults.cardElevation(
        ),
        border = BorderStroke(1.dp, color = Color.Black),
        shape = RoundedCornerShape(20.dp)
    ) {
        Greeting(modifier = Modifier, name = name)
    }
}


@Composable
private fun Greeting(modifier: Modifier = Modifier, name: String) {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

        Row(modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Column(modifier = Modifier
                .weight(1f)) {

                Text(text = "Hello",
                    style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold))
                Text(text = "$name!")
                if (expanded) {
                    Text(
                        text = ("Composem ipsum color sit lazy, " +
                                "padding theme elit, sed do bouncy. ").repeat(4),
                    )
                }
            }

            IconButton(onClick = { expanded = !expanded },
                modifier = Modifier.align(Alignment.Top)) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = if (expanded) {
                        "Show less"
                    } else {
                        "Show more"
                    }
                )
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

@Preview(
    showBackground = true,
    widthDp = 320,
    heightDp = 650)
@Composable
fun DefaultPreview() {
    BasicComposeTheme {
        //MyApp(modifier = Modifier.fillMaxSize())
        CardContent(name = "Isaac")
        /*onBoardingScreen(modifier = Modifier.fillMaxSize(),
            onContinueClicked =  {})*/
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview2() {
    BasicComposeTheme {
        CardContent(name = "Isaac")
       // Greetings()
    }
}



