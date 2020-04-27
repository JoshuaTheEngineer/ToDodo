package com.joshuatheengineer.tododo.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

// defines table to create with class
@Entity(tableName="notes")
data class NoteEntity(
    // works only with Integers
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val date: Date?,
    val text: String)