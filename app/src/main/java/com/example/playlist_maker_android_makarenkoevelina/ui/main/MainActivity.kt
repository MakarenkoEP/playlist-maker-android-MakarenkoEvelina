package com.example.playlist_maker_android_makarenkoevelina.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.playlist_maker_android_makarenkoevelina.R
import com.example.playlist_maker_android_makarenkoevelina.ui.navigation.PlaylistHost
import com.example.playlist_maker_android_makarenkoevelina.ui.theme.PlaylistMakerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PlaylistMakerTheme {
                PlaylistHost(navController = rememberNavController())
            }
        }
    }
}

@Composable
internal fun MainScreen(
    onSearchClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    val searchTitle = stringResource(R.string.search)
    val playlistsTitle = stringResource(R.string.playlists)
    val favoritesTitle = stringResource(R.string.favorites)
    val settingsTitle = stringResource(R.string.settings)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .statusBarsPadding()

    ) {
        MainHeader()

        Surface(
            modifier = Modifier.fillMaxWidth().weight(1f),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(
                        start = 16.dp,
                        top = 8.dp,
                        end = 16.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                MainMenuItem(
                    title = searchTitle,
                    iconRes = R.drawable.ic_search,
                    onClick = onSearchClick
                )
                MainMenuItem(
                    title = playlistsTitle,
                    iconRes = R.drawable.ic_library,
                    onClick = {}
                )
                MainMenuItem(
                    title = favoritesTitle,
                    iconRes = R.drawable.ic_favorite,
                    onClick = {}
                )
                MainMenuItem(
                    title = settingsTitle,
                    iconRes = R.drawable.ic_settings,
                    onClick = onSettingsClick
                )
            }
        }
    }
}

@Composable
private fun MainHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = stringResource(R.string.app_name),
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
private fun MainMenuItem(
    title: String,
    @DrawableRes iconRes: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 18.dp),
        verticalAlignment = Alignment.CenterVertically //тут мб стоит переделать, в фигме есть какие-то невидимые области
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = title,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            text = title,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            painter = painterResource(R.drawable.ic_arrow_forward),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.outline
        )
    }
}
