package ru.rayanis.shoppinglistcompose.main_screen

sealed class MainScreenEvent {
    object OnShowEditDialog : MainScreenEvent()
    object OnItemSave : MainScreenEvent()
}
