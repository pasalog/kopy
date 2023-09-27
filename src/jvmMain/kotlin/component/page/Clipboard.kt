package component.page

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import isGlobalWindowVisible
import theme.divider
import theme.slackBlack
import ui.SelectableCopiedItem

object Clipboard {
    @Composable
    fun clipboardListContainer(clipboardList: List<String>) {
        val clipboardManager = LocalClipboardManager.current

        Box(
            modifier = Modifier.background(slackBlack),
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = slackBlack,
                        shape = RectangleShape
                    ),
                    // .border(
                        // border = BorderStroke(1.dp, color = divider),
                        // shape = RectangleShape
                    // ),
                    // .fillMaxHeight(),
                // contentPadding = PaddingValues(top = 15.dp, bottom = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Display the list of copied items
                itemsIndexed(clipboardList.asReversed()) { index, item ->
                    SelectableCopiedItem.copiedItemView(order = index + 1, text = item, onClick = { text ->
                        clipboardManager.setText(AnnotatedString(text))
                        isGlobalWindowVisible = false
                    })
                }
            }
        }
    }

}
