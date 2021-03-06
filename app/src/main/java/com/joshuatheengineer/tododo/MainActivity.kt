package com.joshuatheengineer.tododo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.joshuatheengineer.tododo.databinding.ActivityMainBinding

import com.joshuatheengineer.tododo.database.NoteEntity
import com.joshuatheengineer.tododo.utils.SampleData

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var bindingActivityMainBinding: ActivityMainBinding
    private lateinit var mAdapter: NoteListAdapter
    private var noteData: ArrayList<NoteEntity> = arrayListOf<NoteEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindingActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingActivityMainBinding.root
        setContentView(view)

        initRecyclerView()

        fab.setOnClickListener { view ->
            var intent = Intent(this, EditorActivity::class.java)
            startActivity(intent)
        }

        noteData.addAll(SampleData.getNotes()!!)
        for (note in noteData) {
            Log.i("ToDodoNotes", note.toString())
        }
    }

    private fun initRecyclerView() {
        bindingActivityMainBinding.contentMain.recyclerView.setHasFixedSize(true)
        var layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        bindingActivityMainBinding.contentMain.recyclerView.layoutManager = layoutManager

        mAdapter = NoteListAdapter(noteData, this)
        bindingActivityMainBinding.contentMain.recyclerView.adapter = mAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
