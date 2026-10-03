package com.example.playlist_maker_android_makarenkoevelina.ui.settings

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import com.example.playlist_maker_android_makarenkoevelina.R
import com.example.playlist_maker_android_makarenkoevelina.ui.theme.PlaylistMakerTheme
import androidx.core.net.toUri

class SettingsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PlaylistMakerTheme {
                SettingsScreen(
                    onBackClick = { finish() },
                    onShareClick = { message ->
                        val intent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, message)
                        }
                        openExternal(Intent.createChooser(intent, null), R.string.settings_no_share_app)
                    },
                    onSupportClick = { email, subject, body ->
                        val intent = Intent(Intent.ACTION_SENDTO).apply {
                            data = "mailto:".toUri()
                            putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                            putExtra(Intent.EXTRA_SUBJECT, subject)
                            putExtra(Intent.EXTRA_TEXT, body)
                        }
                        openExternal(intent, R.string.settings_no_email_app)
                    },
                    onAgreementClick = { url ->
                        openExternal(
                            Intent(Intent.ACTION_VIEW, url.toUri()),
                            R.string.settings_no_browser_app
                        )
                    }
                )
            }
        }
    }

    private fun openExternal(intent: Intent, @StringRes missingAppMessage: Int) {
        try {
            startActivity(intent)
        } catch (_: ActivityNotFoundException) {
            Toast.makeText(this, missingAppMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
