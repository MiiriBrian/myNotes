package com.example.mynotes.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.example.mynotes.model.Note

@Database (entities = [Note::class], version = 1)
//create abstract functions within here

abstract class NoteDatabase: RoomDatabase() {
    //declare NoteDao Interface

    abstract fun getNoteDao(): NoteDao

//static object accessible anywhere in the code
    companion object {
        @Volatile //changes made on one thread are immediately visible to other threads
        private var instance :NoteDatabase? = null
        private val LOCK = Any()

    //ensuring that only one instance of db is created here
    //only one thread executes this

        operator fun  invoke (context: Context) =  instance ?:
            synchronized(LOCK) {
                instance ?:
                createDatabase(context).also {
                    instance = it
                }
            }

        private fun createDatabase (context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java,
                "note_db"
            ).build()
    }
}