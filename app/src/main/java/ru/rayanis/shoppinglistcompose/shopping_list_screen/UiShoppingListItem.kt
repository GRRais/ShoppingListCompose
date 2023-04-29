package ru.rayanis.shoppinglistcompose.shopping_list_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showBackground = true)
@Composable
fun UiShoppingListItem() {
    ConstraintLayout(modifier = Modifier.padding(
        start = 3.dp, top = 18.dp, end = 3.dp
    )) {
        val (card) = createRefs()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(card) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "List 1",
                    style =
                )
            }
        }
    }
}