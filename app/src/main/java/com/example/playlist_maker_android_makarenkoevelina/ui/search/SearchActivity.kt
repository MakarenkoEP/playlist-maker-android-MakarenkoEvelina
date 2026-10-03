package com.example.playlist_maker_android_makarenkoevelina.ui.search

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.playlist_maker_android_makarenkoevelina.R
import com.example.playlist_maker_android_makarenkoevelina.ui.components.BackButton
import com.example.playlist_maker_android_makarenkoevelina.ui.components.HeaderTitle
import com.example.playlist_maker_android_makarenkoevelina.ui.theme.LocalSearchFieldColors
import com.example.playlist_maker_android_makarenkoevelina.ui.theme.PlaylistMakerTheme
import com.example.playlist_maker_android_makarenkoevelina.ui.theme.YPBlack

class SearchActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PlaylistMakerTheme {
                SearchScreen { finish() }
            }
        }
    }
}

@Composable
private fun SearchScreen(onBackClick: () -> Unit) {
    var query by rememberSaveable { mutableStateOf("") }
    val searchColors = LocalSearchFieldColors.current
    val searchTitle = stringResource(R.string.search)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 4.dp, top = 4.dp)
                    .width(304.dp)
                    .height(48.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackButton(onClick = onBackClick)
                HeaderTitle(text = searchTitle)
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) {
            BasicTextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .height(36.dp)
                    .background(searchColors.background, RoundedCornerShape(8.dp)),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyLarge.copy(color = YPBlack),
                cursorBrush = SolidColor(searchColors.cursor),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = {}),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .size(16.dp),
                            tint = searchColors.icon
                        )
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            if (query.isEmpty()) {
                                Text(
                                    text = searchTitle,
                                    color = searchColors.icon,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                            innerTextField()
                        }
                        if (query.isNotEmpty()) {
                            Box(
                                modifier = Modifier
                                    .width(40.dp)
                                    .height(36.dp)
                                    .clickable { query = "" },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = stringResource(R.string.clear_search),
                                    modifier = Modifier.size(16.dp),
                                    tint = searchColors.icon
                                )
                            }
                        }
                    }
                }
            )
        }
    }
}
