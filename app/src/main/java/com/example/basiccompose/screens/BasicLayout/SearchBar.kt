package com.example.basiccompose.screens.BasicLayout

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccompose.R
import com.example.basiccompose.ui.theme.BasicComposeTheme
import com.example.basiccompose.ui.theme.md_theme_light_onTertiary
import com.example.basiccompose.ui.theme.typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
){
    TextField(
        value = " ",
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search , contentDescription = "search" )
        },
        onValueChange = {},
        colors = TextFieldDefaults.textFieldColors(
        ),
        placeholder = {
                      Text(text = "Search")
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}


@Composable
fun AlignYourBodyElements(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,
    @StringRes text: Int,

){

    Column(
        modifier = modifier
            .background(md_theme_light_onTertiary)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )

        Text(
            text = stringResource(id = text),
            modifier = Modifier.paddingFromBaseline(top =24.dp, bottom = 8.dp),
            style = typography.bodyMedium)
    }

}


@Composable
fun FavouriteCardCollection(
    modifier: Modifier = Modifier,
    @DrawableRes imageId: Int,
    @StringRes textId: Int
) {

    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
            .padding(8.dp)
           // .background( color = MaterialTheme.colorScheme.surfaceVariant,)
    ) {

        Row(
            modifier = modifier
                .width(255.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = stringResource(id = textId),
                style = typography.titleMedium
            )
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun DefaultPreview11(){
    BasicComposeTheme {
        //SearchBar()
        AlignYourBodyElements(
            drawable = R.drawable.ab1_inversions,
            text = R.string.ab1_inversions
        )
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun SearchBarPreview(){
    BasicComposeTheme {
        SearchBar()
    }
}


@Preview(showBackground = true )
@Composable
fun FavouriteCollectionCardPreview(){
    BasicComposeTheme {
        FavouriteCardCollection(
            imageId = R.drawable.fc2_nature_meditations,
            textId = R.string.fc2_nature_meditations)
    }
}
