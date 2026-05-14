package com.patelomkumar.arttodoapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a single art project / task for the painter.
 *
 * @param id        Auto-generated primary key
 * @param title     Name of the artwork / project
 * @param medium    Painting medium e.g. "Oil on canvas"
 * @param description Details, inspiration, notes about the project
 * @param dueDate   Target completion date stored as "YYYY-MM-DD"
 * @param status    One of: "ONGOING", "UPCOMING", "FINISHED"
 */
@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val medium: String = "",
    val description: String = "",
    val dueDate: String = "",
    val status: String          // "ONGOING" | "UPCOMING" | "FINISHED"
)
