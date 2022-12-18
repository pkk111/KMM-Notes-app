package com.pkk.kmmapp.android.di

import android.app.Application
import com.pkk.kmmapp.data.local.DatabaseDriverFactory
import com.pkk.kmmapp.data.note.SQLDelightNoteDataSource
import com.pkk.kmmapp.domain.Note.NoteDataSource
import com.pxkk.kmmapp.notesapp.database.NotesDatabase
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideDataSource(driver: SqlDriver): NoteDataSource {
        return SQLDelightNoteDataSource(NotesDatabase(driver))
    }
}