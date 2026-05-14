package com.patelomkumar.arttodoapp.ui.shared

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.patelomkumar.arttodoapp.repository.TaskRepository

/**
 * ViewModelFactory — required because TaskViewModel has a constructor parameter (repository).
 *
 * Android cannot create a ViewModel with constructor args on its own,
 * so we provide this factory to tell it how to build TaskViewModel.
 *
 * Usage in a Fragment:
 *   val viewModel: TaskViewModel by viewModels { TaskViewModelFactory(repository) }
 */
class TaskViewModelFactory(private val repository: TaskRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            return TaskViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
