package com.pkk.kmmapp.data.local

import android.content.Context
import com.pxkk.kmmapp.notesapp.database.NotesDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(NotesDatabase.Schema, context, "note.db")
    }
}