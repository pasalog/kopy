package component.page

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.unit.dp
import theme.DarkColorPalette
import theme.divider
import theme.slackBlack

object Info {
    @Composable
    fun General() {
        val clipboardManager = LocalClipboardManager.current

        Box(
            modifier = Modifier.background(slackBlack),
        ) {
            Column(
                modifier = Modifier
                    .width(1000.dp)
                    .background(
                        color = slackBlack,
                        shape = RectangleShape
                    )
                    .border(
                        border = BorderStroke(1.dp, color = divider),
                        shape = RectangleShape
                    )
                    .fillMaxHeight(),
                // contentPadding = PaddingValues(top = 15.dp, bottom = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Display the list of copied items
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "KoalasCore, mailto: cagatay@koalascore.io",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.width(32.dp),
                        color = DarkColorPalette.onSurface
                    )
                }
            }
        }
    }
}