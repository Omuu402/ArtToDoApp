package com.patelomkumar.arttodoapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.patelomkumar.arttodoapp.model.Task

/**
 * Data Access Object — all CRUD operations for the Task table.
 *
 * Room generates the SQL automatically from these annotations.
 */
@Dao
interface TaskDao {

    // ── CREATE ───────────────────────────────────────────────────────────────

    /**
     * Insert a new task. If a task with the same ID somehow exists, replace it.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    // ── READ ─────────────────────────────────────────────────────────────────

    /**
     * Get all tasks whose status matches the given value.
     * Returns LiveData so the UI updates automatically when data changes.
     *
     * @param status  "ONGOING", "UPCOMING", or "FINISHED"
     */
    @Query("SELECT * FROM tasks WHERE status = :status ORDER BY id DESC")
    fun getTasksByStatus(status: String): LiveData<List<Task>>

    /**
     * Get a single task by its ID (used when opening the edit dialog).
     */
    @Query("SELECT * FROM tasks WHERE id = :id LIMIT 1")
    suspend fun getTaskById(id: Int): Task?

    // ── UPDATE ───────────────────────────────────────────────────────────────

    /**
     * Update an existing task (matched by primary key).
     */
    @Update
    suspend fun updateTask(task: Task)

    // ── DELETE ───────────────────────────────────────────────────────────────

    /**
     * Delete a specific task.
     */
    @Delete
    suspend fun deleteTask(task: Task)

    /**
     * Delete a task directly by its ID.
     */
    @Query("DELETE FROM tasks WHERE id = :id")
    suspend fun deleteTaskById(id: Int)
}
