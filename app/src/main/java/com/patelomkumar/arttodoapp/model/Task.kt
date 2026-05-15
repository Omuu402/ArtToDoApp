package com.patelomkumar.arttodoapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val medium: String = "",
    val description: String = "",
    val dueDate: String = "",
    val status: String
)
