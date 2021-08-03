package com.example.musfeat.domain.usecase.db

import com.example.musfeat.domain.entities.User

interface RemoteDB {

    suspend fun createUser(user: User)
}