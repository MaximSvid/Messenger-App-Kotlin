package com.syntax_institut.whatssyntax.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class NotesData  (
    @PrimaryKey (autoGenerate = true)
    var id: Long = 0,
    var name: String,
    var text: String,

)




