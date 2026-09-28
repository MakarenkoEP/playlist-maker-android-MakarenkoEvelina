package com.example.playlist_maker_android_makarenkoevelina.ui.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.playlist_maker_android_makarenkoevelina.ui.theme.PlaylistMakerTheme

class SettingsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PlaylistMakerTheme {
            }
        }
    }
}
