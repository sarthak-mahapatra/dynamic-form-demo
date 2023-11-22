package com.maverick.dynamicformdemo.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.maverick.dynamicformdemo.FieldStyle
import com.maverick.dynamicformdemo.FormFieldValidator

class TextInputElement {

    companion object {
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun TextFieldComposable(
            label: String,
            style: FieldStyle,
            fieldValidator: FormFieldValidator
        ) {
            var text by remember { mutableStateOf("") }
            var validationResult by remember {
                mutableStateOf(
                    FormFieldValidator.ValidationResult(
                        true,
                        null
                    )
                )
            }

            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                label = {
                    Text(
                        label,
                        style = TextStyle(fontSize = style.textSize, color = style.textColor)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = style.textColor,
                    containerColor = style.backgroundColor

                ),
                isError = !validationResult.success,
                modifier = Modifier.padding(style.padding),
            )

            if (!validationResult.success) {
                Text(validationResult.errorMessage ?: "", color = Color.Red)
            }
        }
    }
}