package com.example.mynotes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotes.model.Note
import com.example.mynotes.repository.NoteRepository
import kotlinx.coroutines.launch


//setting up bridge betwixt our views and the model
//coroutines to prevent mem leaks
class NoteViewModel(
    app: Application,
    private val noteRepository: NoteRepository): AndroidViewModel(app)
{
    fun addNote(note: Note)  = viewModelScope.launch{
            noteRepository.insertNote(note)
    }

    fun deleteNote(note: Note)  = viewModelScope.launch{
            noteRepository.deleteNote(note)
    }

    fun updateNote(note: Note)  = viewModelScope.launch{
            noteRepository.updateNote(note)
    }

    fun getAllNotes()  = noteRepository.getAllNotes()

    fun searchNote(query : String?) = noteRepository.searchNote(query)

}