package com.maverick.dynamicformdemo

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FormViewModel : ViewModel() {
    var form = mutableStateOf<Form?>(null)

    init {
        viewModelScope.launch {
            form.value = RetrofitInstance.api.getForm().data
        }
    }
}