package ru.rayanis.shoppinglistcompose.note_list_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.rayanis.shoppinglistcompose.ui.theme.BlueLight

@Preview(showBackground = true)
@Composable
fun UiNoteItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 3.dp,
                top = 3.dp,
                end = 3.dp
            )
            .clickable {

            }
    ) {
        Column(
            Modifier.fillMaxWidth()
        ) {
            Row(Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .padding(
                            top = 10.dp,
                            start = 10.dp
                        )
                        .weight(1f),
                    text = "Note 1",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(
                        top = 10.dp,
                        end = 10.dp
                    ),
                    text = "12/12/2023 13:00",
                    color = BlueLight,
                    fontSize = 12.sp
                )
            }
            Row(Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .padding(
                            top = 5.dp,
                            start = 10.dp
                        )
                        .weight(1f),
                    text = "sdsd sdfsdf sdfs ds dgs dgsd gsdgsdg sdgsdg sd gd gd gsdg sdgs" +
                            "dfsdgsd sdgs dgsd gsdg s dg sd g sdg sdgsd gsd gs dg sdg s dg s" +
                            "s dg ds g sd g sd g  ds  gsdgsdgsdg sd g s dg sd ",
                    maxLines = 2
                )
            }
        }
    }
}