package com.syntax_institut.whatssyntax.model

data class Chats(
    val id: Int,
    val contact: Contact,
    val lastMessage: Message
)
