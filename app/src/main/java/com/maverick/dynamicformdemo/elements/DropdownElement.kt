package com.maverick.dynamicformdemo.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.maverick.dynamicformdemo.FieldStyle
import com.maverick.dynamicformdemo.Option

class DropdownElement {
    companion object {
        @Composable
        fun DropdownFieldComposable(
            label: String,
            options: List<Option>?,
            placeholder: String?,
            style: FieldStyle
        ) {
            var expanded by remember { mutableStateOf(false) }
            var selectedIndex by remember { mutableStateOf(-1) }
            val selectedLabel =
                if (selectedIndex >= 0) options?.get(selectedIndex)?.label else placeholder


            Column(modifier = Modifier.padding(style.padding)) {
                Text(
                    text = label,
                    style = TextStyle(color = style.textColor, fontSize = style.textSize)
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth() // Ensure full width
                        .clickable { expanded = true }
                        .padding(top = 8.dp) // Add padding above the dropdown for spacing
                ) {
                    selectedLabel?.let {
                        Text(
                            text = it,
                            modifier = Modifier.weight(1f)
                        )
                    } // Use weight to occupy full width
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "Dropdown Indicator"
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.fillMaxWidth() // Ensure DropdownMenu takes full width
                ) {
                    options?.forEachIndexed { index, option ->
                        DropdownMenuItem(
                            text = { Text(option.label) },
                            onClick = {
                                selectedIndex = index
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
    }
}