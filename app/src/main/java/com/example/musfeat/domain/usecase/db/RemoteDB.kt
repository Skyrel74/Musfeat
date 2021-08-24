package com.example.musfeat.domain.usecase.db

import com.example.musfeat.domain.entities.User

interface RemoteDB {

    /**
     * Function to create [user] in remote db
     * [onComplete] function need to be called after successful execution
     */
    suspend fun createUser(user: User, onCompete: () -> Unit)
}