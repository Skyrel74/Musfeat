package com.example.musfeat.domain.usecase.auth

import com.example.musfeat.domain.entities.User

interface Auth {

    /**
     * Function to sign up user by his [email] and [password]
     * [onComplete] function need to be called after successful execution
     * [onError]    function need to be called after unsuccessful execution
     */
    suspend fun signUp(
        email: String, password: String, user: User,
        onComplete: (user: User) -> Unit, onError: () -> Unit
    )

    /**
     * Function to sign in user by his [email] and [password]
     * [onComplete] function need to be called after successful execution
     * [onError]    function need to be called after unsuccessful execution
     */
    suspend fun signIn(
        email: String, password: String,
        onComplete: () -> Unit, onError: () -> Unit
    )

    /**
     * Function to sign out user
     */
    suspend fun signOut()
}