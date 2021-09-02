package com.example.musfeat.domain.entities.result

sealed class SignInResult {
    object Initial : SignInResult()
    object Success : SignInResult()
    object Error : SignInResult()
    object Loading : SignInResult()
}