package ru.rayanis.shoppinglistcompose.shopping_list_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ShoppingListScreen() {
    Text(
        text = "Shopping list screen",
        modifier = Modifier.fillMaxSize()
            .wrapContentHeight()
            .wrapContentWidth()
    )
}