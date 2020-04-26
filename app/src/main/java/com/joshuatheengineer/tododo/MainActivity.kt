package com.joshuatheengineer.tododo

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.joshuatheengineer.tododo.utils.DBUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Below methods will create a Writable Database
        var helper: DBOpenHelper  = DBOpenHelper(this, null, null, null)
        var database: SQLiteDatabase = helper.writableDatabase

    }
}
