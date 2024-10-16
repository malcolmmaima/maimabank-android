package com.maimabank.core.design.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

// Color definitions
private val WhiteLight = Color(0xFFFFFFFF)
private val WhiteLight_85A = Color(0xD9FFFFFF)
private val WhiteDark = Color(0xF2CCCCCC)

private val BlueLight = Color(0xFF337BE2)
private val BlueDark = Color(0xFF4189EF)

private val GreyLight = Color(0xFFDDDDDD)
private val GreyDark = Color(0xFF555555)

private val Black = Color(0xFF131313)
private val Black_85A = Color(0xA6333333)

private val Aqua = Color(0xFF00BCD4)
private val Teal = Color(0xFF009688)

val Blue100 = Color(0xFF100D40)

val Gray75 = Color(0xFF262626)
val Gray60 = Color(0xFF333333)
val Gray50 = Color(0xFF808289)
val Gray30 = Color(0xFF999999)
val Gray20 = Color(0xFFCCCCCC)
val Gray15 = Color(0xFFCFCFD3)
val Gray5 = Color(0xFFF7F7F7)

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Red = Color(0xFFD13438)
val Gray500 = Color(0xFF6E6E6E)

// color Scheme definitions
val LightColorScheme = lightColors(
    primary = BlueLight,
    onPrimary = WhiteLight,
    secondary = GreyLight,
    background = WhiteLight,
    onBackground = Black,
    surface = WhiteLight,
    onSurface = Black,
    primaryVariant = Aqua,
    secondaryVariant = Teal,
    error = Red
)

val DarkColorScheme = darkColors(
    primary = BlueDark,
    onPrimary = WhiteDark,
    secondary = GreyDark,
    background = Black,
    onBackground = WhiteDark,
    surface = Black,
    onSurface = WhiteDark,
    primaryVariant = Aqua,
    secondaryVariant = Teal,
    error = Red
)
