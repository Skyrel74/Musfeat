package com.example.musfeat.data

import java.util.*

data class TextMessage(
    val text: String,
    override val time: Date,
    override val senderId: String,
    override val messageType: String = MessageType.TEXT
) : Message {
    constructor() : this("", Date(0), "", "")
}
