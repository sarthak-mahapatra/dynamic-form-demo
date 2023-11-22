package com.maverick.dynamicformdemo.elements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class CheckboxElement {
    companion object {
        @Composable
        fun CheckboxInput(
            label: String,
            checked: MutableState<Boolean>,
            modifier: Modifier = Modifier
        ) {
            Row(modifier = modifier) {
                Checkbox(
                    checked = checked.value,
                    onCheckedChange = { checked.value = it }
                )
                Text(text = label, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}