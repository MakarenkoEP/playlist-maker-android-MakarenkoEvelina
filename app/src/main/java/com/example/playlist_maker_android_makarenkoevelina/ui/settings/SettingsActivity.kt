package com.example.playlist_maker_android_makarenkoevelina.ui.settings

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.net.toUri
import com.example.playlist_maker_android_makarenkoevelina.R

internal class SettingsActions(private val context: Context) {
    fun shareApp(message: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, message)
        }
        openExternal(Intent.createChooser(intent, null), R.string.settings_no_share_app)
    }

    fun contactDevelopers(email: String, subject: String, body: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = "mailto:".toUri()
            putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, body)
        }
        openExternal(intent, R.string.settings_no_email_app)
    }

    fun openAgreement(url: String) {
        openExternal(Intent(Intent.ACTION_VIEW, url.toUri()), R.string.settings_no_browser_app)
    }

    private fun openExternal(intent: Intent, @StringRes missingAppMessage: Int) {
        try {
            context.startActivity(intent)
        } catch (_: ActivityNotFoundException) {
            Toast.makeText(context, missingAppMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
