package ru.rayanis.shoppinglistcompose.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ShoppingListItem)

    @Delete
    suspend fun deleteItem(item: ShoppingListItem)

    @Query("DELETE FROM add_item WHERE listID = :listId")
    suspend fun deleteAddItems(listId: Int)

    @Query("SELECT * FROM shop_list_name")
    fun getAllItems(): Flow<List<ShoppingListItem>>

    @Transaction
    suspend fun deleteShoppingList(item: ShoppingListItem) {
        deleteAddItems(item.id!!)
        deleteItem(item)
    }
}