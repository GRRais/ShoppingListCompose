package ru.rayanis.shoppinglistcompose.add_item_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ru.rayanis.shoppinglistcompose.data.AddItem

@Composable
fun AddItemScreen(
    viewModel: AddItemViewModel = hiltViewModel()
) {
    Text(
        text = "Add Item screen",
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .wrapContentWidth()
    )
}