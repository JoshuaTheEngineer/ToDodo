package com.joshuatheengineer.tododo

import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
// Import Snackbar in Gradle 'com.google.android.material:material:1.0.0'
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.joshuatheengineer.tododo.databinding.ActivityMainBinding
/*
    importing BUTTERKNIFE
 */
//import butterknife.BindView
//import butterknife.ButterKnife
import com.joshuatheengineer.tododo.databinding.ContentMainBinding
import com.joshuatheengineer.tododo.model.NoteEntity
import com.joshuatheengineer.tododo.utils.SampleData

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // OPTIONAL: bind the recycler view with ButterKnife
    // @BindView(R.id.recycler_view)
    // lateinit var mRecyclerView: RecyclerView

//    private lateinit var binding: ContentMainBinding
    private lateinit var bindingActivityMainBinding: ActivityMainBinding
    private lateinit var mAdapter: NoteListAdapter


    private var noteData: ArrayList<NoteEntity> = arrayListOf<NoteEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Below methods will create a Writable Database
        var helper: DBOpenHelper  = DBOpenHelper(this, null, null, null)
        var database: SQLiteDatabase = helper.writableDatabase

        // binds butterknife to Main Activity context
        //ButterKnife.bind(this)

        bindingActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingActivityMainBinding.root
        setContentView(view)

        initRecyclerView()

        fab.setOnClickListener { view ->
            // will be used to navigate to next Activity
            var intent = Intent(this, EditorActivity::class.java)
            startActivity(intent)
        }

        noteData.addAll(SampleData.getNotes()!!)
        for (note in noteData) {
            Log.i("ToDodoNotes", note.toString())
        }
    }

    private fun initRecyclerView() {
        // each item in the recyclerview will have the same height
        // avoids remeasurements
        bindingActivityMainBinding.contentMain.recyclerView.setHasFixedSize(true)
        // sets a linear layout for recycler view
        // and sets it recyclerview
        var layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        bindingActivityMainBinding.contentMain.recyclerView.layoutManager = layoutManager

        mAdapter = NoteListAdapter(noteData, this)
        bindingActivityMainBinding.contentMain.recyclerView.adapter = mAdapter
    }

    /**
     * Create a menu inflater
     * Needs a 'menu' resource XML file
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
