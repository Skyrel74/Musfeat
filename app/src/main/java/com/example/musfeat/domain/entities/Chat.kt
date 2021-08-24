package com.example.musfeat.domain.entities

data class Chat(
    val id: String,
    val name: String,
    val userIds: List<String>,
    val lastMessageId: String
)