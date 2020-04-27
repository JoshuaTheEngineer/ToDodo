package com.joshuatheengineer.tododo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteViewHolder: RecyclerView.ViewHolder {
    var mTextView: TextView? = null

    constructor(itemView: View) : super(itemView) {
        mTextView = itemView.findViewById(R.id.textView)
    }
}
