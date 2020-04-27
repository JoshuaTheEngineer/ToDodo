package com.joshuatheengineer.tododo.database

import androidx.lifecycle.LiveData
import androidx.room.*

// DAO annotation that tells Room to generate needed code in background
@Dao
interface NoteDao {

    /**
     * Below are expected SQL Queries
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: NoteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(notes: List<NoteEntity>)

    @Delete
    fun deleteNote(note: NoteEntity)

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getNoteById(id: Int): NoteEntity

    @Query("SELECT * FROM notes ORDER BY date DESC")
    fun getAll(): LiveData<List<NoteEntity>>

    @Query("DELETE FROM notes")
    fun deleteAll(): Int

    @Query("SELECT COUNT(*) FROM notes")
    fun getCount(): Int
}