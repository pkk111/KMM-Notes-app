package com.pkk.kmmapp.data.note

import com.pkk.kmmapp.domain.Note.Note
import com.pkk.kmmapp.domain.Note.NoteDataSource
import com.pkk.kmmapp.domain.Time.DateTimeUtil
import com.pxkk.kmmapp.notesapp.database.NotesDatabase

class SQLDelightNoteDataSource(db: NotesDatabase): NoteDataSource {

    private val queries = db.notesQueries

    override suspend fun insertNote(note: Note) {
        queries.insertNote(
            id = note.id,
            title = note.title,
            content = note.content,
            colorHex = note.colorHex,
            created = DateTimeUtil.toEpocMillies(note.created)
        )
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries
            .getNoteById(id)
            .executeAsOneOrNull()
            ?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries
            .getAllNotes()
            .executeAsList()
            .map { it.toNote() }
    }

    override suspend fun deleteNoteById(id: Long) {
        queries.deleteNoteById(id)
    }

}