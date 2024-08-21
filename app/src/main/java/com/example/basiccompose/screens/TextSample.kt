package com.example.basiccompose.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString

@Composable
fun AnnotatedStringWithListenerSample() {
    // Display a link in the text and log metrics whenever user clicks on it. In that case we handle
    // the link using openUri method of the LocalUriHandler
    val uriHandler = LocalUriHandler.current
    /*Text(
        buildAnnotatedString {
            append("Build better apps faster with ")
            val link =
                LinkAnnotation.Url(
                    "https://developer.android.com/jetpack/compose",
                    TextLinkStyles(SpanStyle(color = Color.Blue))
                ) {
                    val url = (it as LinkAnnotation.Url).url
                    // log some metrics
                    uriHandler.openUri(url)
                }
            withLink(link) { append("Jetpack Compose") }
        }*/
   // )
}