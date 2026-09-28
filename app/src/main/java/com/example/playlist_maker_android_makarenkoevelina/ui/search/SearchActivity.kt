package com.example.playlist_maker_android_makarenkoevelina.ui.search

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.playlist_maker_android_makarenkoevelina.ui.theme.PlaylistMakerTheme

class SearchActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PlaylistMakerTheme {
            }
        }
    }
}
