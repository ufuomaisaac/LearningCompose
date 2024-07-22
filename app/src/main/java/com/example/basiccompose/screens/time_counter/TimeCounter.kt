package com.example.basiccompose.screens.time_counter

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TimeCounter(counter: State<Int>, modifier: Modifier) {

    Text(text = counter.value.toString(),
        fontSize = 45.sp,
        textAlign = TextAlign.Center)

}