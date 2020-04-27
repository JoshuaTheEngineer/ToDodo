package com.joshuatheengineer.tododo.model

import java.util.*

/**
 * Implement a data class to store Data for Note
 * https://kotlinlang.org/docs/reference/data-classes.html
 */
data class NoteEntity(val id: Int, val date: Date?, val text: String)