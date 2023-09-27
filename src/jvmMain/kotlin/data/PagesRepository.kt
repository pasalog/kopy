package data

import model.Page

object PagesRepository {
    val pages = listOf(
        Page(
            id = 1,
            name = "Clipboard",
            title = "Clipboard",
            image = "mutualmobile.png"
        ),
        Page(
            id = 2,
            name = "Info",
            title = "Info",
            image = "blrdroid.png"
        )
    )
}