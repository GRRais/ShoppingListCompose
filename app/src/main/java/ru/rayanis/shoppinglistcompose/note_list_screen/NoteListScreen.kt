package ru.rayanis.shoppinglistcompose.note_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.rayanis.shoppinglistcompose.dialog.MainDialog
import ru.rayanis.shoppinglistcompose.shopping_list_screen.UiShoppingListItem
import ru.rayanis.shoppinglistcompose.ui.theme.EmptyText
import ru.rayanis.shoppinglistcompose.ui.theme.GrayLight
import ru.rayanis.shoppinglistcompose.utils.UiEvent

@Composable
fun NoteListScreen(
    viewModel: NoteLIstViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit
) {
    val itemsList = viewModel.noteList.collectAsState(initial = emptyList())

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { uiEvent ->
            when (uiEvent) {
                is UiEvent.Navigate -> {
                    onNavigate(uiEvent.route)
                }

                else -> {}
            }
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayLight),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        items(itemsList.value) { item ->
            UiNoteItem(item) {event ->
                viewModel.onEvent(event)
            }
        }
    }
    MainDialog(viewModel)
    if (itemsList.value.isEmpty()) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            text = "Empty",
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            color = EmptyText
        )
    }
}