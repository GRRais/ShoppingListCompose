package ru.rayanis.shoppinglistcompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test_item")
data class TestItem(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val isCheck: Boolean,
    val listId: Int
)