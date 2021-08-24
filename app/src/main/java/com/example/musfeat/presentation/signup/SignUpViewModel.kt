package com.example.musfeat.presentation.signup

import android.util.Patterns
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {

    fun isNameValid(name: String): Boolean = name.trim().isNotBlank()

    fun isSurnameValid(surname: String): Boolean = surname.trim().isNotBlank()

    fun isEmailValid(email: String) =
        email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isPasswordValid(password: String) = password.isNotBlank() && password.length > 5

    fun isPasswordMatch(password: String, repeatPassword: String) = password == repeatPassword
}