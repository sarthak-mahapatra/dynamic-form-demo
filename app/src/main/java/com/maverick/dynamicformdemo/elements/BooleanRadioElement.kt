package com.maverick.dynamicformdemo.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class BooleanRadioElement {
    companion object {
        @Composable
        fun BooleanRadio(
            label: String,
            selectedOption: MutableState<Boolean>,
            modifier: Modifier = Modifier
        ) {
            Column(modifier = modifier) {
                Text(label)
                Row {
                    RadioButton(
                        selected = selectedOption.value,
                        onClick = { selectedOption.value = true }
                    )
                    Text("True")
                    Spacer(Modifier.width(8.dp))
                    RadioButton(
                        selected = !selectedOption.value,
                        onClick = { selectedOption.value = false }
                    )
                    Text("False")
                }
            }
        }
    }
}