package com.example.playlist_maker_android_makarenkoevelina.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.playlist_maker_android_makarenkoevelina.ui.theme.PlaylistMakerTheme
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.playlist_maker_android_makarenkoevelina.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PlaylistMakerTheme {
                MainScreen()
            }
        }
    }
}

@Composable
private fun MainScreen() {
    val context = androidx.compose.ui.platform.LocalContext.current
    val searchTitle = stringResource(R.string.search)
    val playlistsTitle = stringResource(R.string.playlists)
    val favoritesTitle = stringResource(R.string.favorites)
    val settingsTitle = stringResource(R.string.settings)
    var currentToast by remember { mutableStateOf<Toast?>(null) }
    val showButtonToast: (String) -> Unit = { title ->
        currentToast?.cancel()
        currentToast = Toast.makeText(
            context,
            context.getString(R.string.button_pressed, title),
            Toast.LENGTH_SHORT
        )
        currentToast?.show()
    }

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
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 8.dp,
                    end = 16.dp
                ),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                MainMenuItem(
                    title = searchTitle,
                    iconRes = R.drawable.ic_search,
                    onClick = { showButtonToast(searchTitle) }
                )
                MainMenuItem(
                    title = playlistsTitle,
                    iconRes = R.drawable.ic_library,
                    onClick = { showButtonToast(playlistsTitle) }
                )
                MainMenuItem(
                    title = favoritesTitle,
                    iconRes = R.drawable.ic_favorite,
                    onClick = { showButtonToast(favoritesTitle) }
                )
                MainMenuItem(
                    title = settingsTitle,
                    iconRes = R.drawable.ic_settings,
                    onClick = { showButtonToast(settingsTitle) }
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
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
            lineHeight = 22.sp,
            letterSpacing = 0.sp
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
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
            lineHeight = 22.sp,
            letterSpacing = 0.sp
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
