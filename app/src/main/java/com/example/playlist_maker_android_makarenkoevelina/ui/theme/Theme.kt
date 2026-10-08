package com.example.playlist_maker_android_makarenkoevelina.ui.theme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class SearchFieldColors(
    val background: Color,
    val icon: Color,
    val cursor: Color
)

private val LightSearchFieldColors = SearchFieldColors(
    background = YPLightGray,
    icon = YPTextGray,
    cursor = Color(0xFF3F8AE0)
)

private val DarkSearchFieldColors = SearchFieldColors(
    background = YPWhite,
    icon = YPBlack,
    cursor = YPBlue
)

val LocalSearchFieldColors = staticCompositionLocalOf { LightSearchFieldColors }

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
    val darkTheme = isSystemInDarkTheme() // в зависимости от системной темы
    CompositionLocalProvider(
        LocalSearchFieldColors provides if (darkTheme) DarkSearchFieldColors else LightSearchFieldColors
    ) {
        MaterialTheme(
            colorScheme = if (darkTheme) {
            DarkColors 
            } else {
                LightColors
            },
            typography = PlaylistMakerTypography,
            content = content
        )
    }
}