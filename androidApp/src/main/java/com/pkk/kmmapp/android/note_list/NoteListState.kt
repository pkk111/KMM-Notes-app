package com.pkk.kmmapp.android.note_list

import com.pkk.kmmapp.domain.Note.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String= "",
    val isSearchActive: Boolean = false
)