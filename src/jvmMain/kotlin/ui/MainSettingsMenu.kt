package ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import component.page.Clipboard
import model.Page
import theme.DarkColorPalette
import theme.divider
import theme.slackBlack

object MainSettingsMenu {
    @Composable
    fun Menu(
        pages: List<Page>,
        selectedPage: Page,
        onPageSelected: (page: Page) -> Unit,
    ) {
        LazyColumn(
        ) {
            itemsIndexed(pages) { index, page ->
                Box {
                    Column(
                        modifier = Modifier
                            .width(200.dp)
                            .background(
                                color = if (selectedPage.id == page.id) divider else slackBlack,
                                shape = RectangleShape
                            )
                            .border(
                                border = BorderStroke(1.dp, color = divider),
                                shape = RectangleShape
                            )
                            .fillMaxHeight(),
                        // contentPadding = PaddingValues(top = 15.dp, bottom = 15.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        SettingsMenu.menuItem(order = 0, text = page.title, onClick = { text ->
                            onPageSelected.invoke(page)
                        })
                    }
                }
            }
        }
    }

    @Composable
    fun ClipboardContainer(
        page: Page,
        clipboardList: List<String>
    ) {
        Column(
            modifier = Modifier
                // .preferredWidth(250.dp)
                .background(
                    color = slackBlack,
                    shape = RectangleShape
                )
                .border(
                    border = BorderStroke(1.dp, color = divider),
                    shape = RectangleShape
                )
                .fillMaxHeight()
        ) {
            InfoHeader(page, clipboardList)
            Divider(color = divider)
            Spacer(
                modifier = Modifier.height(10.dp)
            )
        }
    }

    @Composable
    private fun InfoHeader(page: Page, clipboardList: List<String>) {
        Row(
            modifier = Modifier
                //.preferredHeight(70.dp)
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            when (page.id) {
                1 -> {
                    Clipboard.clipboardListContainer(clipboardList = clipboardList)
                }

                2 -> {
                    Text(
                        text = "KoalasCore, mailto: cagatay@koalascore.io",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.fillMaxWidth(),
                        color = DarkColorPalette.onSurface
                    )
                }

                else -> {
                    Text(
                        text = page.name,
                        color = Color.LightGray,
                        style = MaterialTheme.typography.subtitle2.copy(
                            fontWeight = FontWeight.Bold,
                            // fontFamily = LatoFontBoldFamily
                        )
                    )
                    Spacer(
                        modifier = Modifier.width(10.dp)
                    )
//            Image(
//                bitmap = imageFromResource(Icons.arrowDown),
//                modifier = Modifier.preferredSize(8.dp),
//                colorFilter = ColorFilter.tint(
//                    color = Color.White
//                )
//            )
                    Spacer(
                        modifier = Modifier.weight(1f)
                    )
                    Box(
                        modifier = Modifier
                            //.preferredSize(35.dp)
                            .background(
                                color = Color.White,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                    }
                }
            }
        }
    }
}