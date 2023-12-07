package com.example.basiccompose.screens.BasicLayout

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
//import androidx.compose.foundation.lazy.grid.
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccompose.R
import com.example.basiccompose.ui.theme.BasicComposeTheme
import com.example.basiccompose.ui.theme.md_theme_light_onTertiary
import com.example.basiccompose.ui.theme.typography






/*
var alignYourBodyData = listOf<AlignYourBodyData>(
    AlignYourBodyData(imageId = R.drawable.ab1_inversions, textId = R.string.ab1_inversions),
    AlignYourBodyData(imageId = R.drawable.ab1_inversions, textId = R.string.ab1_inversions),
    AlignYourBodyData(imageId = R.drawable.ab1_inversions, textId = R.string.ab1_inversions),
    AlignYourBodyData(imageId = R.drawable.ab1_inversions, textId = R.string.ab1_inversions),
    AlignYourBodyData(imageId = R.drawable.ab1_inversions, textId = R.string.ab1_inversions),
    AlignYourBodyData(imageId = R.drawable.ab1_inversions, textId = R.string.ab1_inversions),
    AlignYourBodyData(imageId = R.drawable.ab1_inversions, textId = R.string.ab1_inversions)
)
*/

/*var favoriteCollectionsData = listOf<Favouritecard>(
    Favouritecard(imageId = R.drawable.fc2_nature_meditations, textId = R.string.fc2_nature_meditations),
    Favouritecard(imageId = R.drawable.fc2_nature_meditations, textId = R.string.fc2_nature_meditations),
    Favouritecard(imageId = R.drawable.fc2_nature_meditations, textId = R.string.fc2_nature_meditations),
    Favouritecard(imageId = R.drawable.fc2_nature_meditations, textId = R.string.fc2_nature_meditations),
    Favouritecard(imageId = R.drawable.fc2_nature_meditations, textId = R.string.fc2_nature_meditations),
    Favouritecard(imageId = R.drawable.fc2_nature_meditations, textId = R.string.fc2_nature_meditations),
    Favouritecard(imageId = R.drawable.fc2_nature_meditations, textId = R.string.fc2_nature_meditations)
)*/

private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair (
    @DrawableRes val imageId: Int,
    @StringRes val textId: Int
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
){
    Column(modifier =
    modifier.padding(horizontal = 16.dp)) {
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
fun FavoriteCardCollection(
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

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier

    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElements(drawable = item.imageId, text = item.textId )
        }
    }
}

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCardCollection(modifier = Modifier, item.imageId, item.textId,)
        }
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(modifier) {
        Text(text = stringResource(id = title),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp),
            style = typography.titleMedium)

        content()
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier.padding(top = 16.dp)) {

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())) {
        //Spacer(modifier = Modifier.height(16.dp))
        SearchBar()
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }

        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }
        Spacer(modifier = Modifier.height(16.dp))

    }

}

@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.bottom_navigation_home)
                )
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.bottom_navigation_profile)
                )
            },
            selected = false,
            onClick = {}
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppPortrait() {
    BasicComposeTheme{
        Scaffold(
            bottomBar = { BottomNavigation() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}


@Composable
fun AppNavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background) {

        Column(modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            NavigationRailItem(
                selected = true,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null)
                },
                label = {
                    Text(text = stringResource(id = R.string.bottom_navigation_profile))
                },
            )
            NavigationRailItem(
                selected = false,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_home))
                })

        }

    }
}


@Composable
fun AppLandScape(){
        Row {
            AppNavigationRail()
            HomeScreen()
        }
}

@Composable
fun MySootheApp(windowSize: WindowSizeClass) {
    when(windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            AppPortrait()
        }
        WindowWidthSizeClass.Expanded -> {
            AppLandScape()
        }
    }

}

@Preview(showBackground = true, heightDp = 400, widthDp = 800)
@Composable
fun HomeSectionPreview() {
    BasicComposeTheme {
        AppLandScape()
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
        AlignYourBodyRow()
    }
}


@Preview(showBackground = true )
@Composable
fun FavouriteCollectionCardPreview(){
    BasicComposeTheme {
        /* FavouriteCardCollection(
            imageId = R.drawable.fc2_nature_meditations,
            textId = R.string.fc2_nature_meditations)
    */
        FavoriteCollectionsGrid()
    }
}


