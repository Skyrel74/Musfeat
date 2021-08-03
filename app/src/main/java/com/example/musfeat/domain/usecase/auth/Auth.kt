package com.example.musfeat.domain.usecase.auth

interface Auth {

    /**
     * Function to sign up user by his [email] and [password]
     */
    suspend fun signUp(email: String, password: String)

    /**
     * Function to sign in user by his [email] and [password]
     */
    suspend fun signIn(email: String, password: String)

    /**
     * Function to sign out user
     */
    suspend fun signOut()
}