package com.maverick.dynamicformdemo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class FormRenderer {
    @Composable
    fun renderForm(
        form: Form?,
        formFieldFactory: FormFieldFactory,
        formFieldValidator: FormFieldValidator
    ) {
        Column {
            Text(text = form?.formName ?: "FORM_NAME_NOT_AVAILABLE")
            form?.fields?.forEach { field ->
                formFieldFactory.createFormField(field, formFieldValidator)
            } ?: Text("No data available")
        }
    }


}