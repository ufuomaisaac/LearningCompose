
package com.example.basiccompose.screens.ArtSpace

import android.graphics.drawable.shapes.Shape
import android.util.Log
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccompose.R
import com.example.basiccompose.screens.ArtSpace.List.Companion.list
import com.example.basiccompose.ui.theme.BasicComposeTheme
import com.example.basiccompose.ui.theme.Grey
import com.example.basiccompose.ui.theme.PurpleGrey80
import kotlinx.coroutines.processNextEventInCurrentThread
import kotlin.collections.List

@Composable
fun ArtWall(){

    var currentIndex: Int by remember { mutableStateOf(0) }

    Column(modifier = Modifier
        .statusBarsPadding()
        .padding(horizontal = 24.dp, vertical = 8.dp)
        .safeDrawingPadding()
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(list[currentIndex].imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .border(
                    BorderStroke(30.dp, Color.White),
                    RectangleShape
                )
                .height(450.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        ArtDetails(modifier = Modifier.height(100.dp),
            currentIndex = currentIndex,
            list = list)
        Spacer(modifier =Modifier.height(16.dp))
       DisplayController(previous = "Previous",
           next = "Next", currentIndex = currentIndex,
            onNextButtonClicked =  {
               when(currentIndex) {
                   0 -> currentIndex = 1
                   1 -> currentIndex = 2
                   2 -> currentIndex = 3
                   else -> if(currentIndex >= 3) {
                       currentIndex = 0
                   }
               }
            },
           onPreviousButtonClicked = {
               if (currentIndex > 0) {
                   currentIndex--
               } else if (currentIndex == 0) {
                   currentIndex = list.size - 1
               }
           }
           )
    }
}
@Composable
fun ArtDetails(modifier : Modifier = Modifier,
               currentIndex: Int,
               list: List<ArtDescription>){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(PurpleGrey80, shape = RectangleShape)
            .padding(8.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = list[currentIndex].artistTitle,
            fontSize = 25.sp,
            //      fontWeight = FontWeight.Bold
        )

        Text(
            text = buildAnnotatedString {
                val style1 = SpanStyle(fontWeight = FontWeight.Bold)
                pushStyle(style = style1)
                append(list[currentIndex].artworkArtist )
                pop()
                append(" (" + list[currentIndex].artworkYear + ")")
            },
            fontSize = 18.sp,
        )
    }
}


@Composable
fun DisplayController(
    modifier: Modifier = Modifier
        .fillMaxWidth()
       /* .padding(vertical = 16.dp)
        .padding(horizontal = 8.dp)*/,
    previous: String,
    next: String,
    currentIndex: Int,
    onNextButtonClicked: () -> Unit,
    onPreviousButtonClicked: () -> Unit
) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier) {
        Button(
            modifier = Modifier.defaultMinSize(120.dp, 30.dp),
            //modifier = Modifier.width(150.dp),
            onClick = onPreviousButtonClicked
            ) {
            Text(
                text = previous,
                fontSize = 18.sp
            )
        }
        //Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier.defaultMinSize(120.dp, 30.dp),
            // colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            onClick = onNextButtonClicked) {
            Text(
                text = next,
                fontSize = 18.sp
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    BasicComposeTheme {
        ArtWall()
    }
}
