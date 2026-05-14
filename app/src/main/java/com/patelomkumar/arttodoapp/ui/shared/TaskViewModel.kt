package com.patelomkumar.arttodoapp.ui.shared

import androidx.lifecycle.*
import com.patelomkumar.arttodoapp.model.Task
import com.patelomkumar.arttodoapp.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * TaskViewModel — shared by all three fragments (Ongoing, Upcoming, Finished).
 *
 * Key responsibilities:
 * - Exposes LiveData lists for each status tab
 * - Delegates all database calls to the Repository
 * - Uses viewModelScope to launch coroutines (auto-cancelled when ViewModel is cleared)
 *
 * @param repository The single source of truth for task data
 */
class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    // ── LiveData exposed to the UI ────────────────────────────────────────────

    /** Tasks currently being worked on */
    val ongoingTasks: LiveData<List<Task>> = repository.ongoingTasks

    /** Tasks planned but not started yet */
    val upcomingTasks: LiveData<List<Task>> = repository.upcomingTasks

    /** Tasks that have been completed */
    val finishedTasks: LiveData<List<Task>> = repository.finishedTasks

    // ── CRUD actions ──────────────────────────────────────────────────────────

    /**
     * Insert a brand-new task into the database.
     * viewModelScope ensures this is cancelled if the ViewModel is destroyed.
     */
    fun insertTask(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(task)
    }

    /**
     * Update an existing task (e.g. after the user edits it).
     */
    fun updateTask(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(task)
    }

    /**
     * Delete a task by passing the full Task object.
     */
    fun deleteTask(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(task)
    }

    /**
     * Delete a task when you only have its ID (from the RecyclerView adapter).
     */
    fun deleteTaskById(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteById(id)
    }

    /**
     * Fetch a single task by ID — used to populate the Edit dialog.
     * Returns the task inside a new LiveData so the caller can observe it.
     */
    fun getTaskById(id: Int): LiveData<Task?> = liveData(Dispatchers.IO) {
        emit(repository.getById(id))
    }
}
