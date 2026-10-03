package com.example.playlist_maker_android_makarenkoevelina.ui.settings

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.playlist_maker_android_makarenkoevelina.R
import com.example.playlist_maker_android_makarenkoevelina.ui.components.BackButton
import com.example.playlist_maker_android_makarenkoevelina.ui.theme.YPBlue
import com.example.playlist_maker_android_makarenkoevelina.ui.theme.YPLightGray
import com.example.playlist_maker_android_makarenkoevelina.ui.theme.YPTextGray

@Composable
internal fun SettingsScreen(
    onBackClick: () -> Unit,
    onShareClick: (String) -> Unit,
    onSupportClick: (String, String, String) -> Unit,
    onAgreementClick: (String) -> Unit
) {
    val shareMessage = stringResource(R.string.settings_share_message)
    val email = stringResource(R.string.settings_email_address)
    val emailSubject = stringResource(R.string.settings_email_subject)
    val emailBody = stringResource(R.string.settings_email_body)
    val offerUrl = stringResource(R.string.settings_offer_url)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
    ) {
        SettingsHeader(onBackClick)
        Spacer(modifier = Modifier.height(24.dp))
        ThemeRow()
        SettingsActionRow(
            title = stringResource(R.string.settings_share),
            iconRes = R.drawable.ic_share,
            iconWidth = 16.dp,
            iconHeight = 18.dp,
            onClick = { onShareClick(shareMessage) }
        )
        SettingsActionRow(
            title = stringResource(R.string.settings_support),
            iconRes = R.drawable.ic_support,
            iconWidth = 20.dp,
            iconHeight = 18.dp,
            onClick = { onSupportClick(email, emailSubject, emailBody) }
        )
        SettingsActionRow(
            title = stringResource(R.string.settings_agreement),
            iconRes = R.drawable.ic_arrow_forward,
            iconWidth = 24.dp,
            iconHeight = 24.dp,
            onClick = { onAgreementClick(offerUrl) }
        )
    }
}

@Composable
private fun SettingsHeader(onBackClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Row(modifier = Modifier.height(48.dp)) {
            BackButton(onClick = onBackClick)
            Box(
                modifier = Modifier
                    .width(208.dp)
                    .height(48.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = stringResource(R.string.settings),
                    modifier = Modifier.padding(start = 12.dp),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 1
                )
            }
        }
    }
}

@Composable
private fun ThemeRow() {
    val darkTheme = isSystemInDarkTheme() // TODO: убрать после реализации свитча
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(61.dp)
            .padding(start = 16.dp, end = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.settings_dark_theme),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.weight(1f))
        ThemeSwitch(darkTheme)
    }
}

@Composable
private fun ThemeSwitch(darkTheme: Boolean) { // TODO: убрать после реализации свитча
    Box(modifier = Modifier.width(56.dp).height(40.dp)) {
        Icon(
            painter = painterResource(R.drawable.ic_switch_track),
            contentDescription = null,
            modifier = Modifier
                .offset(x = 12.dp, y = 14.dp)
                .size(width = 32.dp, height = 12.dp)
                .alpha(if (darkTheme) 0.48f else 1f),
            tint = if (darkTheme) YPBlue else YPLightGray
        )
        Icon(
            painter = painterResource(R.drawable.ic_switch_knob),
            contentDescription = null,
            modifier = Modifier
                .offset(x = if (darkTheme) 29.dp else 9.dp, y = 11.dp)
                .size(18.dp),
            tint = if (darkTheme) YPBlue else YPTextGray
        )
    }
}

@Composable
private fun SettingsActionRow(
    title: String,
    @DrawableRes iconRes: Int,
    iconWidth: Dp,
    iconHeight: Dp,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(61.dp)
            .clickable(onClick = onClick)
            .padding(start = 16.dp, end = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.weight(1f))
        Box(modifier = Modifier.size(24.dp), contentAlignment = Alignment.Center) {
            Icon(
                painter = painterResource(iconRes),
                contentDescription = null,
                modifier = Modifier.size(width = iconWidth, height = iconHeight),
                tint = MaterialTheme.colorScheme.outline
            )
        }
    }
}
