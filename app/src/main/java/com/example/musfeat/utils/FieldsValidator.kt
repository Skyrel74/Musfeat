package com.example.musfeat.utils

import android.util.Patterns

object FieldsValidator {
    fun isNameValid(name: String): Boolean = name.trim().isNotBlank()

    fun isSurnameValid(surname: String): Boolean = surname.trim().isNotBlank()

    fun isEmailValid(email: String) =
        email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isPasswordValid(password: String) = password.isNotBlank() && password.length > 5

    fun isPasswordMatch(password: String, repeatPassword: String) = password == repeatPassword
}