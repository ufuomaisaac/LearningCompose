package com.example.basiccompose.screens.BasicLayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.basiccompose.R

@Composable
fun GetLemon(){
    LemonButtonAndText()

}

@Composable
fun LemonButtonAndText(modifier: Modifier = Modifier){

    var currentPage by remember{
        mutableStateOf(1)
    }
    var currentImageResourceId by remember {
        mutableStateOf(R.drawable.lemon_tree)
    }

    var currentTextResoureId by remember{
        mutableStateOf(R.string.select_tree)
    }

    var lemonTree = stringResource(id = R.string.select_tree)


    var text = stringResource(id = currentTextResoureId)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = currentImageResourceId),
            contentDescription = "lemon tree",
            modifier = modifier.clickable {
                if(currentPage == 4) {
                    currentPage = 0
                    currentPage++
                } else {
                    currentPage++
                }

                when(currentPage) {
                    1 -> {currentTextResoureId = R.string.select_tree
                        currentImageResourceId = R.drawable.lemon_tree}
                    2 -> {currentTextResoureId = R.string.squeeze_lemon
                        currentImageResourceId = R.drawable.lemon_squeeze }
                    3 -> {currentTextResoureId = R.string.drink_it
                        currentImageResourceId = R.drawable.lemon_drink}
                    4 -> {currentTextResoureId = R.string.start_again
                        currentImageResourceId = R.drawable.lemon_restart}
                }
            })
        Spacer(modifier = Modifier.padding(8.dp))

        Text(text = stringResource(id = currentTextResoureId))
    }
}
