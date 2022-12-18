package com.pkk.kmmapp.di

import com.pkk.kmmapp.data.local.DatabaseDriverFactory
import com.pkk.kmmapp.data.note.SQLDelightNoteDataSource
import com.pkk.kmmapp.domain.Note.NoteDataSource
import com.pxkk.kmmapp.notesapp.database.NotesDatabase

class DatabaseModule {
    private val factory by lazy { DatabaseDriverFactory()}
    val noteDataSource: NoteDataSource by lazy {
        SQLDelightNoteDataSource(NotesDatabase(factory.createDriver()))
    }
}