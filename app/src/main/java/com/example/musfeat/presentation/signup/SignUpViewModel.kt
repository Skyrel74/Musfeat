package com.example.musfeat.presentation.signup

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    fun signUp(email: String, password: String) =
        if (email.isEmailValid())
            viewModelScope.launch {
                auth.signUp(email, password)
            }
        else
            TODO("Отобразить невалидность email")

    private fun String.isEmailValid() =
        this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}