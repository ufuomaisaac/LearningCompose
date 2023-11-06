
package com.example.basiccompose.screens.ArtSpace

import android.graphics.drawable.shapes.Shape
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.example.basiccompose.ui.theme.BasicComposeTheme
import com.example.basiccompose.ui.theme.Grey
import com.example.basiccompose.ui.theme.PurpleGrey80
import kotlinx.coroutines.processNextEventInCurrentThread
import kotlin.collections.List

@Composable
fun ArtWall(){

    var list = listOf<ArtDescription>(
        ArtDescription(imageId = R.drawable.dragon, artistTitle = "Still Life of Blue Rose and Other Flowers", artworkArtist = "John Deo", artworkYear = "2001"),
        ArtDescription(imageId = R.drawable.love, artistTitle = "Dragon King in the outer kingdoms", artworkArtist = "John Deo2", artworkYear = "2002"),
        ArtDescription(imageId = R.drawable.message_in_bottle, artistTitle = "Queen's downsided in the Whole Town ", artworkArtist = "John Deo3", artworkYear = "2003"),
        ArtDescription(imageId = R.drawable.light_bulb, artistTitle = "Dragon King4", artworkArtist = "John Deo4", artworkYear = "2004")
    )


    var currentIndex: Int by remember { mutableStateOf(0) }
    var imageId: Int by remember{ mutableStateOf(list[currentIndex].imageId) }
    var artworkTitle: String by remember { mutableStateOf(list[currentIndex].artistTitle) }
    var artworkArtist: String by remember { mutableStateOf(list[currentIndex].artworkArtist) }
    var artworkYear: String by remember { mutableStateOf(list[currentIndex].artworkYear) }

    Column(modifier = Modifier
        .statusBarsPadding()
        .padding(horizontal = 24.dp, vertical = 8.dp)
        .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.border(
                BorderStroke(30.dp, Color.White),
                RectangleShape
            ).size(300.dp)
        )
        Spacer(modifier = Modifier.height(64.dp))
        ArtDetails(currentIndex = currentIndex, list = list)
        Spacer(modifier =Modifier.height(16.dp))
       DisplayController(previous = "Previous", next = "Next", currentIndex = currentIndex, updateCurrentindex = {currentIndex++})
    }
}
@Composable
fun ArtDetails(modifier : Modifier = Modifier, currentIndex: Int, list: List<ArtDescription>){
    Column(
        modifier = Modifier
            .wrapContentWidth()
            .background(PurpleGrey80, shape = RectangleShape)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = list[currentIndex].artistTitle,
            fontSize = 25.sp,
      //      fontWeight = FontWeight.Bold
        )

        Text(
            text = buildAnnotatedString {
                pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
                append(list[currentIndex].artworkArtist)
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
        .padding(vertical = 16.dp)
        .padding(horizontal = 8.dp),
    previous: String,
    next: String,
    currentIndex: Int,
    updateCurrentindex: () -> Unit
) {

    Row(modifier = modifier) {
        Button(modifier = Modifier.width(150.dp),
            onClick = {
                updateCurrentindex
            }
            ) {
            Text(
                text = previous,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.weight(1f))


        Button(modifier = Modifier.width(150.dp),
            // colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            onClick = {

            }) {
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
