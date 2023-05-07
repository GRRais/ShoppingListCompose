package ru.rayanis.shoppinglistcompose.add_item_screen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ru.rayanis.shoppinglistcompose.data.AddItem
import ru.rayanis.shoppinglistcompose.data.AddItemRepository
import ru.rayanis.shoppinglistcompose.dialog.DialogController
import ru.rayanis.shoppinglistcompose.dialog.DialogEvent
import ru.rayanis.shoppinglistcompose.main_screen.MainScreenEvent
import javax.inject.Inject

@HiltViewModel
class AddItemViewModel @Inject constructor(
    private val repository: AddItemRepository,
    savedStateHandle: SavedStateHandle
): ViewModel(), DialogController {

    var itemsList: Flow<List<AddItem>>? = null

    init {
        val listId = savedStateHandle.get<String>("listId")?.toInt()
        itemsList = listId?.let { repository.getAllItemsById(it) }
        Log.d("MyLog", "List id View model: $listId")
    }

    override var dialogTitle = mutableStateOf("")
        private set
    override var editableText = mutableStateOf("")
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var showEditableText = mutableStateOf(true)
        private set

    fun onEvent() {

    }

    override fun onDialogEvent(event: DialogEvent) {
        when (event) {
            is DialogEvent.OnCancel -> {
                openDialog.value = false
                editableText.value = ""
            }

            is DialogEvent.OnConfirm -> {
                openDialog.value = false
                editableText.value = ""
            }

            is DialogEvent.OnTextChange -> {
                editableText.value = event.text
            }
        }
    }
}