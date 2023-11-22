package com.maverick.dynamicformdemo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maverick.dynamicformdemo.elements.BooleanRadioElement
import com.maverick.dynamicformdemo.elements.CheckboxElement
import com.maverick.dynamicformdemo.elements.DateInputElement
import com.maverick.dynamicformdemo.elements.DropdownElement
import com.maverick.dynamicformdemo.elements.NumberInputElement
import com.maverick.dynamicformdemo.elements.TextInputElement
import java.time.LocalDate

class FormFieldFactory {
    @Composable
    fun createFormField(field: FormField, formFieldValidator: FormFieldValidator) {
        val fieldStyle = getStyleForFieldType(field.type)
        val selectedOption = remember { mutableStateOf(false) }
        val numberState = remember { mutableStateOf(0) }
        val dateState = remember { mutableStateOf(LocalDate.now()) }
        when (field.type) {
            "text_input" -> TextInputElement.TextFieldComposable(
                label = field.label,
                style = fieldStyle,
                fieldValidator = formFieldValidator
            )

            "dropdown" -> DropdownElement.DropdownFieldComposable(
                label = field.label,
                options = field.options,
                placeholder = field.placeholder,
                fieldStyle
            )

            "boolean_radio" -> BooleanRadioElement.BooleanRadio(
                label = field.label,
                selectedOption = selectedOption
            )

            "number_input" -> NumberInputElement.NumberInput(
                label = field.label,
                value = numberState
            )

            "date_input" -> DateInputElement.DateInput(
                label = field.label,
                selectedDate = dateState
            )

            "checkbox" -> CheckboxElement.CheckboxInput(
                label = field.label,
                checked = selectedOption
            )
        }
    }

    private fun getStyleForFieldType(fieldType: String): FieldStyle {
        return FieldStyle(
            textColor = when (fieldType) {
                "text_input" -> Color.Black
                "number_input" -> Color.DarkGray
                "date_input" -> Color.Black
                "checkbox" -> Color.Black
                "boolean_radio" -> Color.Black
                "dropdown", "single_select_dropdown_static", "single_select_dropdown_dynamic" -> Color.Blue
                "multiple_select_dropdown_static", "multiple_select_dropdown_dynamic", "multiple_select_dropdown_dynamic_fullscreen" -> Color.Green
                "section" -> Color.Black
                "composite_input" -> Color.Black
                else -> Color.Gray
            },
            backgroundColor = when (fieldType) {
                "checkbox", "boolean_radio" -> Color.Transparent
                "section" -> Color.LightGray
                else -> Color.White
            },
            textSize = if (fieldType == "section") 18.sp else 16.sp,
            padding = if (fieldType == "section") 20.dp else 16.dp,
            dropdownIconColor = when (fieldType) {
                "dropdown", "single_select_dropdown_static", "single_select_dropdown_dynamic" -> Color.Blue
                "multiple_select_dropdown_static", "multiple_select_dropdown_dynamic", "multiple_select_dropdown_dynamic_fullscreen" -> Color.Green
                else -> Color.Gray
            }
        )
    }


}
