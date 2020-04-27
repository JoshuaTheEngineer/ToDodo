package com.joshuatheengineer.tododo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

// In @Database You can add more than one Entity
// exportSchema determines if you want to keep backups
// In @TypeConverters you can use its conversion classes to convert Date to Long for SQLite
@Database(entities = arrayOf(NoteEntity::class), version=1, exportSchema = false)
@TypeConverters(DBUtils::class)
abstract class NoteDatabase: RoomDatabase() {

    // this way the databse knows about the DAO
    abstract fun getNoteDao(): NoteDao

    // companion so clients can access the database w/o instantiating the class
    companion object{
        val DATABASE_NAME: String  = "notes.db"

        // Volatile, it won't be cached so reads and writes are done from main memory
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase {
            // potentially, multiple threads can ask for a db instance at the same time
            // 'sychronized' allows one thread of execution at a time
            synchronized(this) {
                var instance = INSTANCE
                // checks if there is no database created yet
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        DATABASE_NAME
                    )
                        // migration object is an object that defines how you take all rows with
                        // the old schema and convert them to rows in the new schema,
                        // so that no data is lost
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}