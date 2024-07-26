package com.syntax_institut.whatssyntax.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.syntax_institut.whatssyntax.model.NotesData

@Dao
interface WhatsSyntaxDatabaseDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(notes: NotesData)

    @Delete
    suspend fun delete(note: NotesData)

    @Update
    suspend fun update(note: NotesData)

    @Query("SELECT * FROM notes_table")
    fun getAll(): LiveData<List<NotesData>>

}