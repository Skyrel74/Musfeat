package com.example.musfeat.presentation.signIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musfeat.domain.entities.result.SignInResult
import com.example.musfeat.domain.usecase.auth.Auth
import com.example.musfeat.utils.FieldsValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val auth: Auth) : ViewModel() {
    private val _signInResult: MutableLiveData<SignInResult> = MutableLiveData(SignInResult.Initial)
    val signInResult: LiveData<SignInResult> = _signInResult

    fun isEmailValid(email: String) = FieldsValidator.isEmailValid(email)

    fun isPasswordValid(password: String) = FieldsValidator.isPasswordValid(password)

    // TODO: 02.09.2021 add internet check
    fun login(email: String, password: String) {
        _signInResult.postValue(SignInResult.Loading)
        if (isEmailValid(email) && isPasswordValid(password)) {
            viewModelScope.launch {
                auth.signIn(
                    email = email,
                    password = password,
                    onComplete = { _signInResult.postValue(SignInResult.Success) },
                    onError = { _signInResult.postValue(SignInResult.Error) }
                )
            }
        } else {
            _signInResult.postValue(SignInResult.Error)
        }
    }

}