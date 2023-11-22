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

class MultiSelectElement {
    companion object {
        @Composable
        fun MultipleSelectDropdownStatic(
            label: String,
            options: List<String>,
            selectedOptions: MutableState<List<String>>,
            modifier: Modifier = Modifier
        ) {
            var expanded by remember { mutableStateOf(false) }
            Text(text = label)
            Box(modifier = modifier) {
                Text(
                    text = selectedOptions.value.joinToString(),
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
                            if (option in selectedOptions.value) {
                                selectedOptions.value = selectedOptions.value - option
                            } else {
                                selectedOptions.value = selectedOptions.value + option
                            }
                        }) {
                            //Text(text = option)
                            //if (option in selectedOptions.value) {
                            //  Icon(imageVector = Icons.Default.Check, contentDescription = null)
                            //}
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