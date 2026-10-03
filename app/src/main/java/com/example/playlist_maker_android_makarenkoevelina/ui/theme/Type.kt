package com.example.playlist_maker_android_makarenkoevelina.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.playlist_maker_android_makarenkoevelina.R

private val YSDisplay = FontFamily(
    Font(
        resId = R.font.inter_medium,
        weight = FontWeight.Medium
    )
)

val PlaylistMakerTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = YSDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    )
)
