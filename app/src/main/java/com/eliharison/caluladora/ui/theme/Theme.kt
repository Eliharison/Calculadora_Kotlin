package com.eliharison.caluladora.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primaryContainer = CustomTertiary,
    onPrimaryContainer = CustomOnTertiary,
    primary = CustomPrimary,
    onPrimary = CustomOnPrimary,
    secondary = CustomSecondary,
    onSecondary = CustomOnSecondary,
    tertiary = CustomTertiary,
    onTertiary = CustomOnTertiary,
    background = CustomBackground,
    onBackground = CustomOnBackground,
    surface = CustomSurface,
    onSurface = CustomOnSurface
)

private val LightColorScheme = lightColorScheme(
    primaryContainer = CustomTertiary,
    onPrimaryContainer = CustomOnTertiary,
    primary = CustomPrimary,
    onPrimary = CustomOnPrimary,
    secondary = CustomSecondary,
    onSecondary = CustomOnSecondary,
    tertiary = CustomTertiary,
    onTertiary = CustomOnTertiary,
    background = CustomBackground,
    onBackground = CustomOnBackground,
    surface = CustomSurface,
    onSurface = CustomOnSurface
)

@Composable
fun CaluladoraTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
