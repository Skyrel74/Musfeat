package com.example.musfeat.presentation.signup

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musfeat.domain.entities.User
import com.example.musfeat.domain.usecase.auth.Auth
import com.example.musfeat.domain.usecase.db.RemoteDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val auth: Auth,
    private val remoteDB: RemoteDB
) : ViewModel() {

    fun signUp(email: String, password: String, user: User) {
        viewModelScope.launch {
            auth.signUp(
                email, password,
                remoteDB.createUser(user), print("")
            )
        }
    }

    fun isNameValid(name: String): Boolean = name.trim().isNotBlank()

    fun isSurnameValid(surname: String): Boolean = surname.trim().isNotBlank()

    fun isEmailValid(email: String) =
        email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isPasswordValid(password: String) = password.isNotBlank() && password.length > 5

    fun isPasswordMatch(password: String, repeatPassword: String) = password == repeatPassword
}