package com.example.mynotes.repository

import com.example.mynotes.database.NoteDatabase
import com.example.mynotes.model.Note

class NoteRepository(
    private val db: NoteDatabase
) {
    //NoteDao - Call all functions for insert, update , delete , query , getAllNotes

     suspend fun insertNote (note : Note) = db.getNoteDao().insertNote(note)
     suspend fun deleteNote (note : Note) = db.getNoteDao().deleteNote(note)
     suspend fun updateNote (note : Note) = db.getNoteDao().updateNote(note)

     fun getAllNotes() = db.getNoteDao().getAllNotes()
     fun searchNote(query: String?) = db.getNoteDao().searchNote(query)
}