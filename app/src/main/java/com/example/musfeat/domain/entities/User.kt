package com.example.musfeat.domain.entities

data class User(
    val name: String,
    val surname: String,
    val MusicalInstruments: List<MusicalInstrument>,
    val description: String?,
    val userPicturePath: String?,
    val registrationTokens: String?
)