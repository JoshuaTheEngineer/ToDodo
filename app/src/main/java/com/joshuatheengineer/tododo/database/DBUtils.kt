package com.joshuatheengineer.tododo.database

import androidx.room.TypeConverter
import java.util.*

class DBUtils {
    // Since SQL doesn't support Date unit format,
    // you need to convert to its recognizable Long
    @TypeConverter
    fun toDate(timeStamp: Long): Date? {
        return when(timeStamp == null) {
            true -> null
            false -> Date(timeStamp)
        }
    }

    @TypeConverter
    fun toTimestamp(date: Date): Long? {
        return when(date == null) {
            true -> null
            false -> date.time
        }
    }
}