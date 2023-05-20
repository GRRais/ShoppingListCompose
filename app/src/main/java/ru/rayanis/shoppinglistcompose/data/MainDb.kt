package ru.rayanis.shoppinglistcompose.data

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.DeleteColumn
import androidx.room.RenameColumn
import androidx.room.RenameTable
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec

@Database(
    entities = [
        ShoppingListItem::class,
        AddItem::class,
        NoteItem::class,
        TestItem::class
    ],
    autoMigrations = [AutoMigration(
        from = 6,
        to = 7,
        spec = MainDb.DeleteColumnFromShopList::class
    )
                     ],
    version = 7,
    exportSchema = true
)
abstract class MainDb : RoomDatabase() {

    @RenameColumn(
        "shop_list_name",
        fromColumnName = "time",
        toColumnName = "my_time"
    )

    @DeleteColumn(tableName = "shop_list_name", columnName = "testCounter")
    class DeleteColumnFromShopList: AutoMigrationSpec

    abstract val shoppingListDao: ShoppingListDao
    abstract val noteDao: NoteDao
    abstract val addItemDao: AddItemDao
}