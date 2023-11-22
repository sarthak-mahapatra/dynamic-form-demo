package com.maverick.dynamicformdemo

class FormFieldValidator {
    private fun validateTextField(input: String): ValidationResult {
        return ValidationResult(success = true, errorMessage = null)
    }

    private fun validateDropdownField(input: String): ValidationResult {
        return ValidationResult(success = true, errorMessage = null)
    }

    fun validateField(input: String, type: String) {
        println("type = $type")
        when (type) {
            "text" -> validateTextField(input)
            "dropdown" -> validateDropdownField(input)
        }
    }

    data class ValidationResult(val success: Boolean, val errorMessage: String?)

}
