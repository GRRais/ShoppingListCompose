package ru.rayanis.shoppinglistcompose.note_list_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
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
import ru.rayanis.shoppinglistcompose.ui.theme.BlueLight
import ru.rayanis.shoppinglistcompose.ui.theme.EmptyText
import ru.rayanis.shoppinglistcompose.ui.theme.GrayLight
import ru.rayanis.shoppinglistcompose.ui.theme.Red
import ru.rayanis.shoppinglistcompose.utils.UiEvent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NoteListScreen(
    viewModel: NoteLIstViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val itemsList = viewModel.noteList.collectAsState(initial = emptyList())
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { uiEvent ->
            when (uiEvent) {
                is UiEvent.Navigate -> {
                    onNavigate(uiEvent.route)
                }

                is UiEvent.ShowSnackBar -> {
                    val result = scaffoldState.snackbarHostState.showSnackbar(
                        message = uiEvent.message,
                        actionLabel = "Undone"
                    )
                    if (result == SnackbarResult.ActionPerformed) {
                        viewModel.onEvent(NoteListEvent.UnDoneDeleteItem)
                    }
                }

                else -> {}
            }
        }
    }

    Scaffold(scaffoldState = scaffoldState, snackbarHost = {
        SnackbarHost(hostState = scaffoldState.snackbarHostState) {data ->
            Snackbar(
                snackbarData = data,
                backgroundColor = BlueLight,
                modifier = Modifier.padding(bottom = 100.dp)
            )
        }
    }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayLight),
            contentPadding = PaddingValues(bottom = 100.dp)
        ) {
            items(itemsList.value) { item ->
                UiNoteItem(viewModel.titleColor.value, item) { event ->
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
}