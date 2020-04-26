package com.joshuatheengineer.tododo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.joshuatheengineer.tododo.utils.DBUtils

class DBOpenHelper : SQLiteOpenHelper {

    constructor(context: Context, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int?) :
            super(context, DBUtils.DATABASE_NAME, null, DBUtils.DATABASE_VERSION) { }

    /**
     * Used to create a table
     */
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(DBUtils.TABLE_CREATE)
    }

    /**
     * Called when you change the db version
     * and user opens app the first time it happens
     */
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS " + DBUtils.TABLE_NOTES)
        onCreate(db)
    }

}