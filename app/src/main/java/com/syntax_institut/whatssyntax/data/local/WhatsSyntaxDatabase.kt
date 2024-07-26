package com.syntax_institut.whatssyntax.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.syntax_institut.whatssyntax.model.NotesData

@Database (entities = [NotesData::class], version = 2)
abstract class  NotesDatabase: RoomDatabase() {

    abstract val notesDAO: WhatsSyntaxDatabaseDao
}

private lateinit var INSTANCE: NotesDatabase

fun getDatabase (context: Context): NotesDatabase {
    synchronized(NotesDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                NotesDatabase::class.java,
                "notes_database"
            )
//                .fallbackToDestructiveMigration()
                .build()
        }
        return INSTANCE
    }
}




