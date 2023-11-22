package com.maverick.dynamicformdemo

data class FormField(
    val type: String,
    val label: String,
    val options: List<Option>?,
    val placeholder: String?
)

data class Option(
    val label: String,
    val value: String
)

data class Form(val formName: String,
                val fields: List<FormField>)

data class ApiResponse(
    val data: Form,
    val metaData: MetaData
)

data class MetaData(
    val responseCode: String?
)