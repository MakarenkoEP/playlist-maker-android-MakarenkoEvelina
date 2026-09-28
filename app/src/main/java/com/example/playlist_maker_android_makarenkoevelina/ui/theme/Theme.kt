package com.example.playlist_maker_android_makarenkoevelina.ui.theme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = YPBlue,
    background = YPWhite,
    onBackground = YPBlack,
    surface = YPWhite,
    onSurface = YPBlack,
    outline = YPTextGray
)

private val DarkColors = darkColorScheme(
    primary = YPBlue,
    background = YPBlack,
    onBackground = YPWhite,
    surface = YPBlack,
    onSurface = YPWhite,
    outline = YPWhite
)

@Composable
fun PlaylistMakerTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) { // в зависимости от системной темы
            DarkColors
        } else {
            LightColors
        },
        content = content
    )
}