package dev.surehand.karlsson.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.surehand.karlsson.R

val gothicA1 = FontFamily(
    listOf(
        Font(R.font.gothica1_regular, FontWeight.Normal),
        Font(R.font.gothica1_medium, FontWeight.Medium),
        Font(R.font.gothica1_semibold, FontWeight.SemiBold),
        Font(R.font.gothica1_bold, FontWeight.Bold),
        Font(R.font.gothica1_black, FontWeight.Black),
    )
)

// Set of Material typography styles to start with
val Typography = Typography(

    bodyMedium = TextStyle(
//        color = Black,
//        fontFamily = FontFamily.Default,
        fontFamily = gothicA1,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    ),

    titleLarge = TextStyle(
//        color = Black,
        fontFamily = gothicA1,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),

    titleMedium = TextStyle(
//        color = Black,
        fontFamily = gothicA1,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    )
)