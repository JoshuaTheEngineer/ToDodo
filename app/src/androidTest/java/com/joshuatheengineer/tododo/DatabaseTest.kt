package com.joshuatheengineer.tododo

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.joshuatheengineer.tododo.database.NoteDao
import com.joshuatheengineer.tododo.database.NoteDatabase
import com.joshuatheengineer.tododo.database.NoteEntity
import com.joshuatheengineer.tododo.utils.SampleData
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    companion object {
        const val TAG: String = "Junit"
        private lateinit var mDb: NoteDatabase
        private lateinit var mDao: NoteDao
    }

    @Before
    fun createDb() {
        // get app context
        val context: Context = ApplicationProvider.getApplicationContext<Context>()
        // creates a new db for every test
        mDb = Room.inMemoryDatabaseBuilder(context, NoteDatabase::class.java).build()
        // sets DAO
        mDao = mDb.getNoteDao()
        Log.i(TAG, "createDb")
    }

    @After
    fun closeDb() {
        // close database
        mDb.close()
        Log.i(TAG, "closeDb")
    }

    /**
     * Set up tests with following format: GIVEN, WHEN, and THEN
     */
    @Test
    fun createAndRetrieveNotes() {
        mDao.insertAll(SampleData.getNotes()!!)
        var count: Int = mDao.getCount()
        Log.i(TAG, "createAndRetrieveNotes: count=" + count)
        assertEquals(SampleData.getNotes()?.size, count)
    }

    @Test
    fun compareStrings() {
        mDao.insertAll(SampleData.getNotes()!!)
        val original: NoteEntity = SampleData.getNotes()!!.get(0)
        val fromDb: NoteEntity = mDao.getNoteById(1)
        assertEquals(original.text, fromDb.text)
        assertEquals(1, fromDb.id)
    }
}