package ru.rayanis.shoppinglistcompose.main_screen

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.rayanis.shoppinglistcompose.ui.theme.BlueLight
import ru.rayanis.shoppinglistcompose.ui.theme.GrayLight

@Composable
fun BottomNav(
    currentroute: String?,
    onNavigate: (String) -> Unit
) {
    val listItems = listOf(
        BottomNavItem.ListItem,
        BottomNavItem.NoteItem,
        BottomNavItem.AboutItem,
        BottomNavItem.SettingsItem,
    )
    BottomNavigation(backgroundColor = Color.White) {
        listItems.forEach { bottomNavItem ->

            BottomNavigationItem(
                selected = currentroute == bottomNavItem.route,
                onClick = {
                    onNavigate(bottomNavItem.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(
                            id = bottomNavItem.iconId
                        ),
                        contentDescription = "icon"
                    )
                },
                label = {
                    Text(text = bottomNavItem.title)
                },
                selectedContentColor = BlueLight,
                unselectedContentColor = GrayLight,
                alwaysShowLabel = false
            )
        }
    }
}