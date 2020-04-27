package com.joshuatheengineer.tododo.utils

class DBUtils {
    companion object {
        var DATABASE_NAME: String  = "notes.db"
        var DATABASE_VERSION: Int = 1

        var TABLE_NOTES: String = "notes"
        var NOTE_ID: String  = "_ID"
        var NOTE_TEXT: String = "noteText"
        var NOTE_CREATED: String  = "noteCreated"

        var TABLE_CREATE: String  = "CREATE TABLE " + TABLE_NOTES + " (" +
            NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NOTE_TEXT + " TEXT, " +
            NOTE_CREATED + " TEXT default CURRENT_TIMESTAMP" + ")"
    }
}