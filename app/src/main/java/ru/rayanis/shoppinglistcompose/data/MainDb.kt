package ru.rayanis.shoppinglistcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ShoppingListItem::class, AddItem::class, NoteItem::class],
    version = 1
)
abstract class MainDb: RoomDatabase() {
    abstract val shoppingListDao: ShoppingListDao
}