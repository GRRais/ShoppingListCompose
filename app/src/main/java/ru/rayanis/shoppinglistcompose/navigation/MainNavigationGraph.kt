package ru.rayanis.shoppinglistcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.rayanis.shoppinglistcompose.about_screen.AboutScreen
import ru.rayanis.shoppinglistcompose.add_item_screen.AddItemScreen
import ru.rayanis.shoppinglistcompose.main_screen.MainScreen
import ru.rayanis.shoppinglistcompose.new_note_screen.NewNoteScreen
import ru.rayanis.shoppinglistcompose.note_list_screen.NoteListScreen
import ru.rayanis.shoppinglistcompose.settings_screen.SettingsScreen
import ru.rayanis.shoppinglistcompose.shopping_list_screen.ShoppingListScreen
import ru.rayanis.shoppinglistcompose.utils.Routes

@Composable
fun MainNavigationGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.MAIN_SCREEN) {
        composable(Routes.ADD_ITEM + "/{listId}") {
            AddItemScreen()
        }
        composable(Routes.NEW_NOTE) {
            NewNoteScreen() {
                navController.popBackStack()
            }
        }
        composable(Routes.MAIN_SCREEN) {
            MainScreen(navController)
        }
    }
}