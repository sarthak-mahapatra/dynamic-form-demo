package com.maverick.dynamicformdemo.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

class SingleSelectElement {
    companion object {
        @Composable
        fun SingleSelectDropdownStatic(
            label: String,
            options: List<String>,
            selectedOption: MutableState<String>,
            modifier: Modifier = Modifier
        ) {
            var expanded by remember { mutableStateOf(false) }
            Text(text = label)
            Box(modifier = modifier) {
                Text(
                    text = selectedOption.value,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = true }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    options.forEach { option ->
                        DropdownMenuItem(onClick = {
                            selectedOption.value = option
                            expanded = false
                        }) {
                            //Text(option)
                        }
                    }
                }
            }
        }

        private fun DropdownMenuItem(onClick: () -> Unit, interactionSource: () -> Unit) {
            TODO("Not yet implemented")
        }
    }
}