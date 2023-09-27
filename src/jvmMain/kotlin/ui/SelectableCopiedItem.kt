package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import theme.DarkColorPalette

object SelectableCopiedItem {

    @Composable
    fun copiedItemView(order: Int, text: String, onClick: (String) -> Unit) {
        Row(
            modifier = Modifier.clickable { onClick(text) }.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.Top
        ) {
//            Image(
//                painterResource("logo.png"),
//                "This is image!", modifier = Modifier.size(64.dp)
//            )
            Text(
                text = "$order.",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.width(32.dp),
                color = DarkColorPalette.onSurface
            )
            Text(
                text = text,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.weight(1f),
                color = DarkColorPalette.onSurface
            )
        }
    }
}