package ru.rayanis.shoppinglistcompose.note_list_screen

import ru.rayanis.shoppinglistcompose.data.NoteItem

sealed class NoteListEvent {
    data class OnShowDeleteDialog(val item: NoteItem): NoteListEvent()
    data class OnItemClick(val route: String): NoteListEvent()
    data class OnTextSearchChange(val text: String): NoteListEvent()
    object UnDoneDeleteItem: NoteListEvent()
}