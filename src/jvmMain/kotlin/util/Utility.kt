package util//import androidx.compose.ui.Alignment
//import androidx.compose.ui.unit.Dp
//
//fun getMouseAlignment(): Alignment {
//    val mouseLocation = java.awt.MouseInfo.getPointerInfo().location
//    val mouseX = mouseLocation.x
//    val mouseY = mouseLocation.y
//
//    val offsetX = (mouseX.toFloat() / java.awt.Toolkit.getDefaultToolkit().screenSize.width.toFloat()) * 2 - 1
//    val offsetY = (mouseY.toFloat() / java.awt.Toolkit.getDefaultToolkit().screenSize.height.toFloat()) * 2 - 1
//
//    return Alignment(offsetX = Dp(offsetX), offsetY = Dp(offsetY))
//
//}