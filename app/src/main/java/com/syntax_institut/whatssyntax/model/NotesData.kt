package com.syntax_institut.whatssyntax.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class NotesData  (
    @PrimaryKey (autoGenerate = false)
    var id: Long,
    var name: String,
    var text: String,

)




