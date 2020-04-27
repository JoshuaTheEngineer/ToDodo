package com.joshuatheengineer.tododo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

// defines table to create with class
@Entity(tableName="notes")
data class NoteEntity(
    // works only with Integers
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "date")
    val date: Date?,
    @ColumnInfo(name = "text")
    val text: String)