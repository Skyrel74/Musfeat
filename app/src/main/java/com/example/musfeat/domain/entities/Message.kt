package com.example.musfeat.domain.entities

abstract class Message(
    val id: String,
    val chatId: String,
    val messageType: MessageType
)

enum class MessageType {
    TEXT,
    IMAGE
}