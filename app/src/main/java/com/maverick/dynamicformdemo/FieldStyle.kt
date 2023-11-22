package com.maverick.dynamicformdemo

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

data class FieldStyle(
    val textColor: Color,
    val backgroundColor: Color,
    val textSize: TextUnit,
    val padding: Dp,
    val dropdownIconColor: Color
)
