package com.example.playlist_maker_android_makarenkoevelina.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.playlist_maker_android_makarenkoevelina.ui.theme.PlaylistMakerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PlaylistMakerTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    // 
                }
            }
        }
    }
}
