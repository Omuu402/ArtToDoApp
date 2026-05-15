package com.patelomkumar.arttodoapp.ui.shared

import androidx.lifecycle.*
import com.patelomkumar.arttodoapp.model.Task
import com.patelomkumar.arttodoapp.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    
    val ongoingTasks: LiveData<List<Task>> = repository.ongoingTasks

    
    val upcomingTasks: LiveData<List<Task>> = repository.upcomingTasks

    
    val finishedTasks: LiveData<List<Task>> = repository.finishedTasks

    
    fun insertTask(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(task)
    }

    
    fun updateTask(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(task)
    }

    
    fun deleteTask(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(task)
    }

    
    fun deleteTaskById(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteById(id)
    }

    
    fun getTaskById(id: Int): LiveData<Task?> = liveData(Dispatchers.IO) {
        emit(repository.getById(id))
    }
}
