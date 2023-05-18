package ru.rayanis.shoppinglistcompose.about_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.rayanis.shoppinglistcompose.R
import ru.rayanis.shoppinglistcompose.ui.theme.BlueLight

@Preview(showBackground = true)
@Composable
fun AboutScreen() {
    val uriHandler = LocalUriHandler.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.necologo),
            contentDescription = "Logo",
            modifier = Modifier.size(100.dp),
            tint = BlueLight
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "This app developed by NECO \n" +
                    "Version 1.0.3 \n" +
                    "To get more information: \n",
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .padding(top = 10.dp)
                .clickable {
                    uriHandler.openUri("https://neco-desarrollo.es")
                },
            text = ">>> Click here <<<",
            color = BlueLight
        )
    }
}