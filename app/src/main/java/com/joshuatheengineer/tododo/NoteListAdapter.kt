package com.joshuatheengineer.tododo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joshuatheengineer.tododo.database.NoteEntity

class NoteListAdapter : RecyclerView.Adapter<NoteViewHolder> {
    private lateinit var mNoteList: List<NoteEntity>
    private lateinit var mContext: Context

    constructor(mNoteList: List<NoteEntity>, context: Context){
        this.mNoteList = mNoteList
        this.mContext = context
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteViewHolder {
        var inflater: LayoutInflater = LayoutInflater.from(parent.context)
        var view: View = inflater.inflate(R.layout.notelist_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mNoteList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note: NoteEntity = mNoteList.get(position)
        holder.mTextView!!.text = note.text
    }
}