package com.joshuatheengineer.tododo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joshuatheengineer.tododo.model.NoteEntity

/*
    Android uses Adapters to connect data with View items in the list
 */
class NoteListAdapter : RecyclerView.Adapter<NoteViewHolder> {

    // to hold your data, you need to create a linkedList of Strings
    private lateinit var mNoteList: List<NoteEntity>

    // reads the layout XML description to convert it to corresponding View items
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

    /**
     * Called each time the rows are refreshed with a data object
     */
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note: NoteEntity = mNoteList.get(position)
        holder.mTextView!!.text = note.text
    }
}