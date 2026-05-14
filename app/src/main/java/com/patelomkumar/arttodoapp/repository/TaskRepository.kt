package com.patelomkumar.arttodoapp.repository

import androidx.lifecycle.LiveData
import com.patelomkumar.arttodoapp.database.TaskDao
import com.patelomkumar.arttodoapp.model.Task

/**
 * Repository — sits between the ViewModel and the DAO.
 *
 * The ViewModel should NEVER talk to the DAO directly.
 * The Repository is the single source of truth for all data.
 *
 * This also makes it easy to swap Room for a remote API later
 * without changing any ViewModel or Fragment code.
 */
class TaskRepository(private val taskDao: TaskDao) {

    // ── READ (LiveData — auto-updates the UI) ─────────────────────────────────

    val ongoingTasks: LiveData<List<Task>> = taskDao.getTasksByStatus("ONGOING")
    val upcomingTasks: LiveData<List<Task>> = taskDao.getTasksByStatus("UPCOMING")
    val finishedTasks: LiveData<List<Task>> = taskDao.getTasksByStatus("FINISHED")

    // ── CREATE ────────────────────────────────────────────────────────────────

    /**
     * Insert a new task.
     * Must be called from a coroutine (suspend) so Room doesn't block the UI thread.
     */
    suspend fun insert(task: Task) {
        taskDao.insertTask(task)
    }

    // ── UPDATE ────────────────────────────────────────────────────────────────

    /**
     * Update an existing task.
     */
    suspend fun update(task: Task) {
        taskDao.updateTask(task)
    }

    // ── DELETE ────────────────────────────────────────────────────────────────

    /**
     * Delete a task by its object reference.
     */
    suspend fun delete(task: Task) {
        taskDao.deleteTask(task)
    }

    /**
     * Delete a task by ID (convenient when you only have the ID).
     */
    suspend fun deleteById(id: Int) {
        taskDao.deleteTaskById(id)
    }

    // ── READ SINGLE ───────────────────────────────────────────────────────────

    /**
     * Fetch a single task by ID (used to pre-fill the edit dialog).
     */
    suspend fun getById(id: Int): Task? {
        return taskDao.getTaskById(id)
    }
}
