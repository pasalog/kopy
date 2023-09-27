package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import theme.DarkColorPalette
import theme.divider

object SettingsMenu {
    @Composable
    fun menuItem(order: Int, text: String, onClick: (String) -> Unit) {
        Row(
            modifier = Modifier.clickable { onClick(text) }.padding(horizontal = 16.dp, vertical = 8.dp).fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(modifier = Modifier.padding(10.dp), color = DarkColorPalette.onSurface, text = text)
//            Image(
//                modifier = Modifier
//                    .preferredSize(42.dp)
//                    .padding(6.dp)
//                    .clip(RoundedCornerShape(20))
//                    .clickable {
//                        onWorkspaceSelected.invoke(workspace)
//                    },
//                bitmap = imageFromResource(workspace.image)
//            )
            }
            Spacer(
                modifier = Modifier.height(10.dp).background(color = divider)
            )

//        if (workspace == workspaces.last()) {
//            Image(
//                modifier = Modifier
//                    .preferredSize(34.dp)
//                    .padding(6.dp),
//                bitmap = imageFromResource(Icons.add),
//                colorFilter = ColorFilter.tint(SlackColors.grey)
//            )
//        }
        }
    }
}