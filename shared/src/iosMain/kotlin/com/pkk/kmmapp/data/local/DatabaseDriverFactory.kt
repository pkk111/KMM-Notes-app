package com.pkk.kmmapp.data.local

import com.pxkk.kmmapp.notesapp.database.NotesDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(NotesDatabase.Schema, "note.db")
    }
}