import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import com.github.kwhat.jnativehook.GlobalScreen
import com.github.kwhat.jnativehook.NativeInputEvent
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener
import data.PagesRepository.pages
import theme.slackBlack
import ui.MainSettingsMenu
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.UnsupportedFlavorException
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import kotlin.system.exitProcess

val clipboardList = mutableStateListOf<String>()
var isGlobalWindowVisible = true
val settingPages = pages

@OptIn(ExperimentalFoundationApi::class)
fun main() = application {
    var isWindowVisible by remember { mutableStateOf(true) }

    val windowState =
        rememberWindowState(size = DpSize(1000.dp, 720.dp), position = WindowPosition.Aligned(Alignment.Center))
    Tray(icon = painterResource("logo.png"), menu = {
        Menu(text = "Copied items", content = {
            Item(text = if (isWindowVisible) "Hide Items Window" else "Show Items Window", onClick = {
                isWindowVisible = !isWindowVisible
            })
            Separator()
        })
        Item(text = if (isWindowVisible) "Hide Items Window" else "Show Items Window", onClick = {
            isWindowVisible = !isWindowVisible
        })
        Separator()
        Item("Exit", onClick = { exitProcess(1) })
    })

    val windowAdapter by lazy {
        object : WindowAdapter() {
            override fun windowActivated(e: WindowEvent?) {
                super.windowActivated(e) // add mutableState logic
            }
        }
    }

    GlobalScreen.registerNativeHook()
    GlobalScreen.addNativeKeyListener(object : NativeKeyListener {
        override fun nativeKeyPressed(event: NativeKeyEvent) {
            // Check if the shortcut key combination was pressed
            val key = event.keyCode
            if (event.modifiers == (NativeInputEvent.SHIFT_MASK and NativeInputEvent.CTRL_MASK)
                && event.keyCode == NativeKeyEvent.VC_V
            ) {
                // Perform the desired action here
                isWindowVisible = !isWindowVisible
            }
        }

        override fun nativeKeyTyped(event: NativeKeyEvent) {}
        override fun nativeKeyReleased(event: NativeKeyEvent) {}
    })

    // Create a Compose desktop window
    Window(
        icon = painterResource("logo.png"),
        onCloseRequest = { isWindowVisible = false },
        title = "Kopy",
        resizable = true,
        // undecorated = true,
        state = windowState,
        visible = isWindowVisible
    ) {
        window.addWindowListener(windowAdapter)
        MaterialTheme(
            colors = colors.copy(
                primary = slackBlack
            ),
        ) {
            Row(
                modifier = Modifier.background(
                    color = slackBlack
                ).fillMaxSize()
            ) {
                val selectedPage = remember { mutableStateOf(pages.first()) }

                // Left side of container.
                MainSettingsMenu.Menu(pages = settingPages, selectedPage = selectedPage.value) {
                    selectedPage.value = it
                }

                // Right side of container.
                MainSettingsMenu.ClipboardContainer(page = selectedPage.value, clipboardList = clipboardList)
            }
        }
        window.requestFocus()
    }
//    pointerPosition = Alignment
//    Popup(alignment = MouseInfo.getPointerInfo().location, ) {
//
//    }

    // Monitor clipboard changes
    Thread {
        while (true) {
            val clipboardText = getClipboardText()
            clipboardText?.let {
                if (!clipboardList.contains(it)) {
                    clipboardList.add(it)
                    print(clipboardList)
                }
            }
            Thread.sleep(100)
        }
    }.start()
}

fun getClipboardText(): String? {
    return try {
        Toolkit.getDefaultToolkit().systemClipboard.getContents(null)?.let { contents ->
            contents.getTransferData(DataFlavor.stringFlavor) as? String
        }
    } catch (e: UnsupportedFlavorException) {
        print(e)
        null
    }
}