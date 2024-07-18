package com.example.basiccompose.screens.BasicLayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccompose.R
import com.example.basiccompose.ui.theme.BasicComposeTheme

@Composable
fun ComposeArticle(modifier: Modifier = Modifier){
    Column {
        Image(painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = "Artical image",
            modifier = Modifier.fillMaxWidth())

        Text(
            text = "Jetpack Compose tutorial",
            modifier.padding(16.dp),
            fontSize = 24.sp,
            //textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(id = R.string.first_text),
            modifier.padding(16.dp),
            textAlign = TextAlign.Justify
            )

        Text(
            text = stringResource(id = R.string.second_text),
            modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicComposeTheme {
        ComposeArticle()
    }
}