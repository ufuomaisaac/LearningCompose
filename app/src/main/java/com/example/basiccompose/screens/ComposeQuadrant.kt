package com.example.basiccompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.basiccompose.R

@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxWidth() ) {
        Row(modifier = modifier.weight(1f)) {
            Card1(
                title = stringResource(id = R.string.compose_quadrant_title1),
                content = stringResource(id = R.string.compose_quadrant_content1),
                backgroundColor = Color(0xFFEADDFF),
                modifier = modifier.weight(1f),
            )

            Card1(
                title = stringResource(id = R.string.compose_quadrant_title2),
                content = stringResource(id = R.string.compose_quadrant_content2),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = modifier.weight(1f),
            )
        }
        Row(modifier = modifier.weight(1f)) {
            Card1(
                title = stringResource(id = R.string.compose_quadrant_title3) ,
                content = stringResource(id = R.string.compose_quadrant_content3),
                modifier = modifier.weight(1f),
                backgroundColor = Color(0xFFB69DF8)
            )

            Card1(
                title = stringResource(id = R.string.compose_quadrant_title4) ,
                content = stringResource(id = R.string.compose_quadrant_content4),
                modifier = modifier.weight(1f),
                backgroundColor = Color(0xFFF6EDFF)
            )
            
        }
    }
}

@Composable
fun Card1(modifier: Modifier,
         title: String,
         content: String,
         backgroundColor: Color){

    Column( modifier = modifier
        .fillMaxSize()
        .background(backgroundColor)
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        Text(text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )

        Text(text = content,
            textAlign = TextAlign.Justify)
    }
}
