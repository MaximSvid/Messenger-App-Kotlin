package com.syntax_institut.whatssyntax.model

data class Calls(
    val contact: Contact,
    val incoming: Boolean,
    val accepted: Boolean,
    val time: String

)


