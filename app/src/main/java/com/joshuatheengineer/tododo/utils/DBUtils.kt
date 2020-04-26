package com.joshuatheengineer.tododo.utils

class DBUtils {
    companion object {
        // Constants for DB name and version
        var DATABASE_NAME: String  = "notes.db"
        var DATABASE_VERSION: Int = 1 // needs to update

        // Constants for identifying table and columns
        var TABLE_NOTES: String = "notes"
        var NOTE_ID: String  = "_ID"
        var NOTE_TEXT: String = "noteText"
        var NOTE_CREATED: String  = "noteCreated"

        // SQL to create table
        var TABLE_CREATE: String  = "CREATE TABLE " + TABLE_NOTES + " (" +
            NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +  // increments Primary Key for each row
            NOTE_TEXT + " TEXT, " +
            NOTE_CREATED + " TEXT default CURRENT_TIMESTAMP" + ")"; // Current Timestamp will be used to sort each row
    }
}