package com.maverick.dynamicformdemo.elements

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import java.time.LocalDate

class DateInputElement {
    companion object {
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun DateInput(
            label: String,
            selectedDate: MutableState<LocalDate>,
            modifier: Modifier = Modifier
        ) {
            // You will need to implement a date picker dialog
            TextField(
                value = selectedDate.value.toString(),
                onValueChange = { /* Show Date Picker */ },
                label = { Text(label) },
                readOnly = true,
                modifier = modifier
            )
        }
    }
}