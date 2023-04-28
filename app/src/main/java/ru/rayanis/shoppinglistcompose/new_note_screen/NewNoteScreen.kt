package ru.rayanis.shoppinglistcompose.new_note_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NewNoteScreen() {
    Text(
        text = "New note screen",
        modifier = Modifier.fillMaxSize()
            .wrapContentHeight()
            .wrapContentWidth()
    )
}