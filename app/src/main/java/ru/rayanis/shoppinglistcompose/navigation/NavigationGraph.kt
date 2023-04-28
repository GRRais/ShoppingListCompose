package ru.rayanis.shoppinglistcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.rayanis.shoppinglistcompose.about_screen.AboutScreen
import ru.rayanis.shoppinglistcompose.note_list_screen.NoteListScreen
import ru.rayanis.shoppinglistcompose.settings_screen.SettingsScreen
import ru.rayanis.shoppinglistcompose.shopping_list_screen.ShoppingListScreen
import ru.rayanis.shoppinglistcompose.utils.Routes

@Composable
fun NavigationGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.SHOPPING_LIST) {
        composable(Routes.SHOPPING_LIST) {
            ShoppingListScreen()
        }
        composable(Routes.NOTE_LIST) {
            NoteListScreen()
        }
        composable(Routes.ABOUT) {
            AboutScreen()
        }
        composable(Routes.SETTINGS) {
            SettingsScreen()
        }
    }
}