package com.syntax_institut.whatssyntax.model

data class Contact(
    val id: Int,
    val name: String,
    val number: String,
    val image: String,
    val status: Status?
)