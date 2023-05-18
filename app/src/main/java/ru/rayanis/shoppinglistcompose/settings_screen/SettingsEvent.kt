package ru.rayanis.shoppinglistcompose.settings_screen

sealed class SettingsEvent {
    data class OnItemSelected(val color: String): SettingsEvent()
}
