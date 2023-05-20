package ru.rayanis.shoppinglistcompose.settings_screen

import androidx.compose.ui.graphics.Color
import ru.rayanis.shoppinglistcompose.ui.theme.GreenLight
import ru.rayanis.shoppinglistcompose.ui.theme.Red
import ru.rayanis.shoppinglistcompose.ui.theme.Yellow

object ColorUtils {
    val colorList = listOf(
        "#487242",
        "#22b9a8",
        "#452e52",
        "#f28f93",
        "#ff00a1",
        "#041cf6",
        "#532a4a",
        "#774084",
        "#09cf6a",
        "#668096"
    )

    fun getProgressColor(progress: Float): Color {
        return when(progress) {
            in 0.0 .. 0.339 -> Red
            in 0.34 .. 0.669 -> Yellow
            in 0.67 .. 1.0 -> GreenLight
            else -> Red
        }
    }
}