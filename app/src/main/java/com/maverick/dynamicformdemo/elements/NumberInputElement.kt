package com.maverick.dynamicformdemo.elements

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

class NumberInputElement {
    companion object {
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun NumberInput(
            label: String,
            value: MutableState<Int>,
            modifier: Modifier = Modifier
        ) {
            TextField(
                value = value.value.toString(),
                onValueChange = { newValue ->
                    value.value = newValue.toIntOrNull() ?: value.value
                },
                label = { Text(label) },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = modifier
            )
        }
    }
}