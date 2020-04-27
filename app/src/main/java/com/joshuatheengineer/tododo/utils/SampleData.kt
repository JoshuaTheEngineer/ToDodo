package com.joshuatheengineer.tododo.utils

import com.joshuatheengineer.tododo.database.NoteEntity
import java.util.*
import kotlin.collections.ArrayList


class SampleData{
    companion object {
        private const val SAMPLE_TEXT_1 = "Dodos are amazing birds"
        private const val SAMPLE_TEXT_2 = "Dodos are extinct\n except in the movie Ice Age"
        private const val SAMPLE_TEXT_3 =
            "The DoDo is an extinct flightless bird that was endemic to the island of Mauritius, east of Madagascar in the Indian Ocean.\n\n" +
                    "The dodo's closest genetic relative was the also-extinct Rodrigues solitaire, the two forming the subfamily Raphinae of the family of pigeons and doves."

        private fun getDate(diff: Int): Date? {
            val cal = GregorianCalendar()
            cal.add(Calendar.MILLISECOND, diff)
            return cal.getTime()
        }

        fun getNotes(): List<NoteEntity>? {
            val notes: ArrayList<NoteEntity> = ArrayList()
            notes.add(NoteEntity(1, getDate(0), SAMPLE_TEXT_1))
            notes.add(NoteEntity(2, getDate(-1), SAMPLE_TEXT_2))
            notes.add(NoteEntity(3, getDate(-2), SAMPLE_TEXT_3))
            return notes
        }
    }
}