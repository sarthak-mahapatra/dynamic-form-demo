package com.maverick.dynamicformdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: FormViewModel by viewModels()
        val formRenderer = FormRenderer()
        val formFieldFactory = FormFieldFactory()
        val formFieldValidator = FormFieldValidator()

        setContent {
            val form = viewModel.form.value
            formRenderer.renderForm(form, formFieldFactory, formFieldValidator)
        }
    }
}



