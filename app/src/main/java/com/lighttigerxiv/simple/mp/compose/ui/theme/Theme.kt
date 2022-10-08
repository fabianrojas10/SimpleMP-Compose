package com.lighttigerxiv.simple.mp.compose.ui.theme

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


private val LightBlueColors = lightColorScheme(
    primary = blue_theme_light_primary,
    onPrimary = blue_theme_light_onPrimary,
    primaryContainer = blue_theme_light_primaryContainer,
    onPrimaryContainer = blue_theme_light_onPrimaryContainer,
    secondary = blue_theme_light_secondary,
    onSecondary = blue_theme_light_onSecondary,
    secondaryContainer = blue_theme_light_secondaryContainer,
    onSecondaryContainer = blue_theme_light_onSecondaryContainer,
    tertiary = blue_theme_light_tertiary,
    onTertiary = blue_theme_light_onTertiary,
    tertiaryContainer = blue_theme_light_tertiaryContainer,
    onTertiaryContainer = blue_theme_light_onTertiaryContainer,
    error = blue_theme_light_error,
    errorContainer = blue_theme_light_errorContainer,
    onError = blue_theme_light_onError,
    onErrorContainer = blue_theme_light_onErrorContainer,
    background = blue_theme_light_background,
    onBackground = blue_theme_light_onBackground,
    surface = blue_theme_light_surface,
    onSurface = blue_theme_light_onSurface,
    surfaceVariant = blue_theme_light_surfaceVariant,
    onSurfaceVariant = blue_theme_light_onSurfaceVariant,
    outline = blue_theme_light_outline,
    inverseOnSurface = blue_theme_light_inverseOnSurface,
    inverseSurface = blue_theme_light_inverseSurface,
    inversePrimary = blue_theme_light_inversePrimary,
    surfaceTint = blue_theme_light_surfaceTint,
)


private val DarkBlueColors = darkColorScheme(
    primary = blue_theme_dark_primary,
    onPrimary = blue_theme_dark_onPrimary,
    primaryContainer = blue_theme_dark_primaryContainer,
    onPrimaryContainer = blue_theme_dark_onPrimaryContainer,
    secondary = blue_theme_dark_secondary,
    onSecondary = blue_theme_dark_onSecondary,
    secondaryContainer = blue_theme_dark_secondaryContainer,
    onSecondaryContainer = blue_theme_dark_onSecondaryContainer,
    tertiary = blue_theme_dark_tertiary,
    onTertiary = blue_theme_dark_onTertiary,
    tertiaryContainer = blue_theme_dark_tertiaryContainer,
    onTertiaryContainer = blue_theme_dark_onTertiaryContainer,
    error = blue_theme_dark_error,
    errorContainer = blue_theme_dark_errorContainer,
    onError = blue_theme_dark_onError,
    onErrorContainer = blue_theme_dark_onErrorContainer,
    background = blue_theme_dark_background,
    onBackground = blue_theme_dark_onBackground,
    surface = blue_theme_dark_surface,
    onSurface = blue_theme_dark_onSurface,
    surfaceVariant = blue_theme_dark_surfaceVariant,
    onSurfaceVariant = blue_theme_dark_onSurfaceVariant,
    outline = blue_theme_dark_outline,
    inverseOnSurface = blue_theme_dark_inverseOnSurface,
    inverseSurface = blue_theme_dark_inverseSurface,
    inversePrimary = blue_theme_dark_inversePrimary,
    surfaceTint = blue_theme_dark_surfaceTint,
)


private val LightRedColors = lightColorScheme(
    primary = red_theme_light_primary,
    onPrimary = red_theme_light_onPrimary,
    primaryContainer = red_theme_light_primaryContainer,
    onPrimaryContainer = red_theme_light_onPrimaryContainer,
    secondary = red_theme_light_secondary,
    onSecondary = red_theme_light_onSecondary,
    secondaryContainer = red_theme_light_secondaryContainer,
    onSecondaryContainer = red_theme_light_onSecondaryContainer,
    tertiary = red_theme_light_tertiary,
    onTertiary = red_theme_light_onTertiary,
    tertiaryContainer = red_theme_light_tertiaryContainer,
    onTertiaryContainer = red_theme_light_onTertiaryContainer,
    error = red_theme_light_error,
    errorContainer = red_theme_light_errorContainer,
    onError = red_theme_light_onError,
    onErrorContainer = red_theme_light_onErrorContainer,
    background = red_theme_light_background,
    onBackground = red_theme_light_onBackground,
    surface = red_theme_light_surface,
    onSurface = red_theme_light_onSurface,
    surfaceVariant = red_theme_light_surfaceVariant,
    onSurfaceVariant = red_theme_light_onSurfaceVariant,
    outline = red_theme_light_outline,
    inverseOnSurface = red_theme_light_inverseOnSurface,
    inverseSurface = red_theme_light_inverseSurface,
    inversePrimary = red_theme_light_inversePrimary,
    surfaceTint = red_theme_light_surfaceTint,
)


private val DarkRedColors = darkColorScheme(
    primary = red_theme_dark_primary,
    onPrimary = red_theme_dark_onPrimary,
    primaryContainer = red_theme_dark_primaryContainer,
    onPrimaryContainer = red_theme_dark_onPrimaryContainer,
    secondary = red_theme_dark_secondary,
    onSecondary = red_theme_dark_onSecondary,
    secondaryContainer = red_theme_dark_secondaryContainer,
    onSecondaryContainer = red_theme_dark_onSecondaryContainer,
    tertiary = red_theme_dark_tertiary,
    onTertiary = red_theme_dark_onTertiary,
    tertiaryContainer = red_theme_dark_tertiaryContainer,
    onTertiaryContainer = red_theme_dark_onTertiaryContainer,
    error = red_theme_dark_error,
    errorContainer = red_theme_dark_errorContainer,
    onError = red_theme_dark_onError,
    onErrorContainer = red_theme_dark_onErrorContainer,
    background = red_theme_dark_background,
    onBackground = red_theme_dark_onBackground,
    surface = red_theme_dark_surface,
    onSurface = red_theme_dark_onSurface,
    surfaceVariant = red_theme_dark_surfaceVariant,
    onSurfaceVariant = red_theme_dark_onSurfaceVariant,
    outline = red_theme_dark_outline,
    inverseOnSurface = red_theme_dark_inverseOnSurface,
    inverseSurface = red_theme_dark_inverseSurface,
    inversePrimary = red_theme_dark_inversePrimary,
    surfaceTint = red_theme_dark_surfaceTint,
)

private val LightPurpleColors = lightColorScheme(
    primary = purple_theme_light_primary,
    onPrimary = purple_theme_light_onPrimary,
    primaryContainer = purple_theme_light_primaryContainer,
    onPrimaryContainer = purple_theme_light_onPrimaryContainer,
    secondary = purple_theme_light_secondary,
    onSecondary = purple_theme_light_onSecondary,
    secondaryContainer = purple_theme_light_secondaryContainer,
    onSecondaryContainer = purple_theme_light_onSecondaryContainer,
    tertiary = purple_theme_light_tertiary,
    onTertiary = purple_theme_light_onTertiary,
    tertiaryContainer = purple_theme_light_tertiaryContainer,
    onTertiaryContainer = purple_theme_light_onTertiaryContainer,
    error = purple_theme_light_error,
    errorContainer = purple_theme_light_errorContainer,
    onError = purple_theme_light_onError,
    onErrorContainer = purple_theme_light_onErrorContainer,
    background = purple_theme_light_background,
    onBackground = purple_theme_light_onBackground,
    surface = purple_theme_light_surface,
    onSurface = purple_theme_light_onSurface,
    surfaceVariant = purple_theme_light_surfaceVariant,
    onSurfaceVariant = purple_theme_light_onSurfaceVariant,
    outline = purple_theme_light_outline,
    inverseOnSurface = purple_theme_light_inverseOnSurface,
    inverseSurface = purple_theme_light_inverseSurface,
    inversePrimary = purple_theme_light_inversePrimary,
    surfaceTint = purple_theme_light_surfaceTint,
)


private val DarkPurpleColors = darkColorScheme(
    primary = purple_theme_dark_primary,
    onPrimary = purple_theme_dark_onPrimary,
    primaryContainer = purple_theme_dark_primaryContainer,
    onPrimaryContainer = purple_theme_dark_onPrimaryContainer,
    secondary = purple_theme_dark_secondary,
    onSecondary = purple_theme_dark_onSecondary,
    secondaryContainer = purple_theme_dark_secondaryContainer,
    onSecondaryContainer = purple_theme_dark_onSecondaryContainer,
    tertiary = purple_theme_dark_tertiary,
    onTertiary = purple_theme_dark_onTertiary,
    tertiaryContainer = purple_theme_dark_tertiaryContainer,
    onTertiaryContainer = purple_theme_dark_onTertiaryContainer,
    error = purple_theme_dark_error,
    errorContainer = purple_theme_dark_errorContainer,
    onError = purple_theme_dark_onError,
    onErrorContainer = purple_theme_dark_onErrorContainer,
    background = purple_theme_dark_background,
    onBackground = purple_theme_dark_onBackground,
    surface = purple_theme_dark_surface,
    onSurface = purple_theme_dark_onSurface,
    surfaceVariant = purple_theme_dark_surfaceVariant,
    onSurfaceVariant = purple_theme_dark_onSurfaceVariant,
    outline = purple_theme_dark_outline,
    inverseOnSurface = purple_theme_dark_inverseOnSurface,
    inverseSurface = purple_theme_dark_inverseSurface,
    inversePrimary = purple_theme_dark_inversePrimary,
    surfaceTint = purple_theme_dark_surfaceTint,
)

private val LightYellowColors = lightColorScheme(
    primary = yellow_theme_light_primary,
    onPrimary = yellow_theme_light_onPrimary,
    primaryContainer = yellow_theme_light_primaryContainer,
    onPrimaryContainer = yellow_theme_light_onPrimaryContainer,
    secondary = yellow_theme_light_secondary,
    onSecondary = yellow_theme_light_onSecondary,
    secondaryContainer = yellow_theme_light_secondaryContainer,
    onSecondaryContainer = yellow_theme_light_onSecondaryContainer,
    tertiary = yellow_theme_light_tertiary,
    onTertiary = yellow_theme_light_onTertiary,
    tertiaryContainer = yellow_theme_light_tertiaryContainer,
    onTertiaryContainer = yellow_theme_light_onTertiaryContainer,
    error = yellow_theme_light_error,
    errorContainer = yellow_theme_light_errorContainer,
    onError = yellow_theme_light_onError,
    onErrorContainer = yellow_theme_light_onErrorContainer,
    background = yellow_theme_light_background,
    onBackground = yellow_theme_light_onBackground,
    surface = yellow_theme_light_surface,
    onSurface = yellow_theme_light_onSurface,
    surfaceVariant = yellow_theme_light_surfaceVariant,
    onSurfaceVariant = yellow_theme_light_onSurfaceVariant,
    outline = yellow_theme_light_outline,
    inverseOnSurface = yellow_theme_light_inverseOnSurface,
    inverseSurface = yellow_theme_light_inverseSurface,
    inversePrimary = yellow_theme_light_inversePrimary,
    surfaceTint = yellow_theme_light_surfaceTint,
)


private val DarkYellowColors = darkColorScheme(
    primary = yellow_theme_dark_primary,
    onPrimary = yellow_theme_dark_onPrimary,
    primaryContainer = yellow_theme_dark_primaryContainer,
    onPrimaryContainer = yellow_theme_dark_onPrimaryContainer,
    secondary = yellow_theme_dark_secondary,
    onSecondary = yellow_theme_dark_onSecondary,
    secondaryContainer = yellow_theme_dark_secondaryContainer,
    onSecondaryContainer = yellow_theme_dark_onSecondaryContainer,
    tertiary = yellow_theme_dark_tertiary,
    onTertiary = yellow_theme_dark_onTertiary,
    tertiaryContainer = yellow_theme_dark_tertiaryContainer,
    onTertiaryContainer = yellow_theme_dark_onTertiaryContainer,
    error = yellow_theme_dark_error,
    errorContainer = yellow_theme_dark_errorContainer,
    onError = yellow_theme_dark_onError,
    onErrorContainer = yellow_theme_dark_onErrorContainer,
    background = yellow_theme_dark_background,
    onBackground = yellow_theme_dark_onBackground,
    surface = yellow_theme_dark_surface,
    onSurface = yellow_theme_dark_onSurface,
    surfaceVariant = yellow_theme_dark_surfaceVariant,
    onSurfaceVariant = yellow_theme_dark_onSurfaceVariant,
    outline = yellow_theme_dark_outline,
    inverseOnSurface = yellow_theme_dark_inverseOnSurface,
    inverseSurface = yellow_theme_dark_inverseSurface,
    inversePrimary = yellow_theme_dark_inversePrimary,
    surfaceTint = yellow_theme_dark_surfaceTint,
)


private val LightOrangeColors = lightColorScheme(
    primary = orange_theme_light_primary,
    onPrimary = orange_theme_light_onPrimary,
    primaryContainer = orange_theme_light_primaryContainer,
    onPrimaryContainer = orange_theme_light_onPrimaryContainer,
    secondary = orange_theme_light_secondary,
    onSecondary = orange_theme_light_onSecondary,
    secondaryContainer = orange_theme_light_secondaryContainer,
    onSecondaryContainer = orange_theme_light_onSecondaryContainer,
    tertiary = orange_theme_light_tertiary,
    onTertiary = orange_theme_light_onTertiary,
    tertiaryContainer = orange_theme_light_tertiaryContainer,
    onTertiaryContainer = orange_theme_light_onTertiaryContainer,
    error = orange_theme_light_error,
    errorContainer = orange_theme_light_errorContainer,
    onError = orange_theme_light_onError,
    onErrorContainer = orange_theme_light_onErrorContainer,
    background = orange_theme_light_background,
    onBackground = orange_theme_light_onBackground,
    surface = orange_theme_light_surface,
    onSurface = orange_theme_light_onSurface,
    surfaceVariant = orange_theme_light_surfaceVariant,
    onSurfaceVariant = orange_theme_light_onSurfaceVariant,
    outline = orange_theme_light_outline,
    inverseOnSurface = orange_theme_light_inverseOnSurface,
    inverseSurface = orange_theme_light_inverseSurface,
    inversePrimary = orange_theme_light_inversePrimary,
    surfaceTint = orange_theme_light_surfaceTint,
)


private val DarkOrangeColors = darkColorScheme(
    primary = orange_theme_dark_primary,
    onPrimary = orange_theme_dark_onPrimary,
    primaryContainer = orange_theme_dark_primaryContainer,
    onPrimaryContainer = orange_theme_dark_onPrimaryContainer,
    secondary = orange_theme_dark_secondary,
    onSecondary = orange_theme_dark_onSecondary,
    secondaryContainer = orange_theme_dark_secondaryContainer,
    onSecondaryContainer = orange_theme_dark_onSecondaryContainer,
    tertiary = orange_theme_dark_tertiary,
    onTertiary = orange_theme_dark_onTertiary,
    tertiaryContainer = orange_theme_dark_tertiaryContainer,
    onTertiaryContainer = orange_theme_dark_onTertiaryContainer,
    error = orange_theme_dark_error,
    errorContainer = orange_theme_dark_errorContainer,
    onError = orange_theme_dark_onError,
    onErrorContainer = orange_theme_dark_onErrorContainer,
    background = orange_theme_dark_background,
    onBackground = orange_theme_dark_onBackground,
    surface = orange_theme_dark_surface,
    onSurface = orange_theme_dark_onSurface,
    surfaceVariant = orange_theme_dark_surfaceVariant,
    onSurfaceVariant = orange_theme_dark_onSurfaceVariant,
    outline = orange_theme_dark_outline,
    inverseOnSurface = orange_theme_dark_inverseOnSurface,
    inverseSurface = orange_theme_dark_inverseSurface,
    inversePrimary = orange_theme_dark_inversePrimary,
    surfaceTint = orange_theme_dark_surfaceTint,
)

private val LightGreenColors = lightColorScheme(
    primary = green_theme_light_primary,
    onPrimary = green_theme_light_onPrimary,
    primaryContainer = green_theme_light_primaryContainer,
    onPrimaryContainer = green_theme_light_onPrimaryContainer,
    secondary = green_theme_light_secondary,
    onSecondary = green_theme_light_onSecondary,
    secondaryContainer = green_theme_light_secondaryContainer,
    onSecondaryContainer = green_theme_light_onSecondaryContainer,
    tertiary = green_theme_light_tertiary,
    onTertiary = green_theme_light_onTertiary,
    tertiaryContainer = green_theme_light_tertiaryContainer,
    onTertiaryContainer = green_theme_light_onTertiaryContainer,
    error = green_theme_light_error,
    errorContainer = green_theme_light_errorContainer,
    onError = green_theme_light_onError,
    onErrorContainer = green_theme_light_onErrorContainer,
    background = green_theme_light_background,
    onBackground = green_theme_light_onBackground,
    surface = green_theme_light_surface,
    onSurface = green_theme_light_onSurface,
    surfaceVariant = green_theme_light_surfaceVariant,
    onSurfaceVariant = green_theme_light_onSurfaceVariant,
    outline = green_theme_light_outline,
    inverseOnSurface = green_theme_light_inverseOnSurface,
    inverseSurface = green_theme_light_inverseSurface,
    inversePrimary = green_theme_light_inversePrimary,
    surfaceTint = green_theme_light_surfaceTint,
)


private val DarkGreenColors = darkColorScheme(
    primary = green_theme_dark_primary,
    onPrimary = green_theme_dark_onPrimary,
    primaryContainer = green_theme_dark_primaryContainer,
    onPrimaryContainer = green_theme_dark_onPrimaryContainer,
    secondary = green_theme_dark_secondary,
    onSecondary = green_theme_dark_onSecondary,
    secondaryContainer = green_theme_dark_secondaryContainer,
    onSecondaryContainer = green_theme_dark_onSecondaryContainer,
    tertiary = green_theme_dark_tertiary,
    onTertiary = green_theme_dark_onTertiary,
    tertiaryContainer = green_theme_dark_tertiaryContainer,
    onTertiaryContainer = green_theme_dark_onTertiaryContainer,
    error = green_theme_dark_error,
    errorContainer = green_theme_dark_errorContainer,
    onError = green_theme_dark_onError,
    onErrorContainer = green_theme_dark_onErrorContainer,
    background = green_theme_dark_background,
    onBackground = green_theme_dark_onBackground,
    surface = green_theme_dark_surface,
    onSurface = green_theme_dark_onSurface,
    surfaceVariant = green_theme_dark_surfaceVariant,
    onSurfaceVariant = green_theme_dark_onSurfaceVariant,
    outline = green_theme_dark_outline,
    inverseOnSurface = green_theme_dark_inverseOnSurface,
    inverseSurface = green_theme_dark_inverseSurface,
    inversePrimary = green_theme_dark_inversePrimary,
    surfaceTint = green_theme_dark_surfaceTint,
)

private val LightPinkColors = lightColorScheme(
    primary = pink_theme_light_primary,
    onPrimary = pink_theme_light_onPrimary,
    primaryContainer = pink_theme_light_primaryContainer,
    onPrimaryContainer = pink_theme_light_onPrimaryContainer,
    secondary = pink_theme_light_secondary,
    onSecondary = pink_theme_light_onSecondary,
    secondaryContainer = pink_theme_light_secondaryContainer,
    onSecondaryContainer = pink_theme_light_onSecondaryContainer,
    tertiary = pink_theme_light_tertiary,
    onTertiary = pink_theme_light_onTertiary,
    tertiaryContainer = pink_theme_light_tertiaryContainer,
    onTertiaryContainer = pink_theme_light_onTertiaryContainer,
    error = pink_theme_light_error,
    errorContainer = pink_theme_light_errorContainer,
    onError = pink_theme_light_onError,
    onErrorContainer = pink_theme_light_onErrorContainer,
    background = pink_theme_light_background,
    onBackground = pink_theme_light_onBackground,
    surface = pink_theme_light_surface,
    onSurface = pink_theme_light_onSurface,
    surfaceVariant = pink_theme_light_surfaceVariant,
    onSurfaceVariant = pink_theme_light_onSurfaceVariant,
    outline = pink_theme_light_outline,
    inverseOnSurface = pink_theme_light_inverseOnSurface,
    inverseSurface = pink_theme_light_inverseSurface,
    inversePrimary = pink_theme_light_inversePrimary,
    surfaceTint = pink_theme_light_surfaceTint,
)


private val DarkPinkColors = darkColorScheme(
    primary = pink_theme_dark_primary,
    onPrimary = pink_theme_dark_onPrimary,
    primaryContainer = pink_theme_dark_primaryContainer,
    onPrimaryContainer = pink_theme_dark_onPrimaryContainer,
    secondary = pink_theme_dark_secondary,
    onSecondary = pink_theme_dark_onSecondary,
    secondaryContainer = pink_theme_dark_secondaryContainer,
    onSecondaryContainer = pink_theme_dark_onSecondaryContainer,
    tertiary = pink_theme_dark_tertiary,
    onTertiary = pink_theme_dark_onTertiary,
    tertiaryContainer = pink_theme_dark_tertiaryContainer,
    onTertiaryContainer = pink_theme_dark_onTertiaryContainer,
    error = pink_theme_dark_error,
    errorContainer = pink_theme_dark_errorContainer,
    onError = pink_theme_dark_onError,
    onErrorContainer = pink_theme_dark_onErrorContainer,
    background = pink_theme_dark_background,
    onBackground = pink_theme_dark_onBackground,
    surface = pink_theme_dark_surface,
    onSurface = pink_theme_dark_onSurface,
    surfaceVariant = pink_theme_dark_surfaceVariant,
    onSurfaceVariant = pink_theme_dark_onSurfaceVariant,
    outline = pink_theme_dark_outline,
    inverseOnSurface = pink_theme_dark_inverseOnSurface,
    inverseSurface = pink_theme_dark_inverseSurface,
    inversePrimary = pink_theme_dark_inversePrimary,
    surfaceTint = pink_theme_dark_surfaceTint,
)

@Composable
fun ComposeSimpleMPTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    currentTheme: String = "System",
    content: @Composable () -> Unit
) {

    val context = LocalContext.current
    val supportsMaterialYou = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val themeAccent = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE).getString("ThemeAccent", "Default")

    val colors = when{


        currentTheme == "Dark" && themeAccent == "Blue" -> DarkBlueColors
        currentTheme == "Dark" && themeAccent == "Red" -> DarkRedColors
        currentTheme == "Dark" && themeAccent == "Purple" -> DarkPurpleColors
        currentTheme == "Dark" && themeAccent == "Yellow" -> DarkYellowColors
        currentTheme == "Dark" && themeAccent == "Orange" -> DarkOrangeColors
        currentTheme == "Dark" && themeAccent == "Green" -> DarkGreenColors
        currentTheme == "Dark" && themeAccent == "Pink" -> DarkPinkColors

        supportsMaterialYou && currentTheme == "Dark" -> dynamicDarkColorScheme(context)

        currentTheme == "Light" && themeAccent == "Blue" -> LightBlueColors
        currentTheme == "Light" && themeAccent == "Red" -> LightRedColors
        currentTheme == "Light" && themeAccent == "Purple" -> LightPurpleColors
        currentTheme == "Light" && themeAccent == "Yellow" -> LightYellowColors
        currentTheme == "Light" && themeAccent == "Orange" -> LightOrangeColors
        currentTheme == "Light" && themeAccent == "Green" -> LightGreenColors
        currentTheme == "Light" && themeAccent == "Pink" -> LightPinkColors

        supportsMaterialYou && currentTheme == "Light" -> dynamicLightColorScheme(context)

        themeAccent == "Blue" && useDarkTheme -> DarkBlueColors
        themeAccent == "Red" && useDarkTheme -> DarkRedColors
        themeAccent == "Purple" && useDarkTheme -> DarkPurpleColors
        themeAccent == "Yellow" && useDarkTheme -> DarkYellowColors
        themeAccent == "Orange" && useDarkTheme -> DarkOrangeColors
        themeAccent == "Green" && useDarkTheme -> DarkGreenColors
        themeAccent == "Pink" && useDarkTheme -> DarkPinkColors

        supportsMaterialYou && useDarkTheme -> dynamicDarkColorScheme(context)

        themeAccent == "Blue" && !useDarkTheme -> LightBlueColors
        themeAccent == "Red" && !useDarkTheme -> LightRedColors
        themeAccent == "Purple" && !useDarkTheme -> LightPurpleColors
        themeAccent == "Yellow" && !useDarkTheme -> LightYellowColors
        themeAccent == "Orange" && !useDarkTheme -> LightOrangeColors
        themeAccent == "Green" && !useDarkTheme -> LightGreenColors
        themeAccent == "Pink" && !useDarkTheme -> LightPinkColors

        supportsMaterialYou && !useDarkTheme -> dynamicLightColorScheme(context)

        useDarkTheme -> DarkBlueColors

        else-> LightBlueColors
    }

    when(currentTheme){

        "Dark" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        "Light" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }



    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}