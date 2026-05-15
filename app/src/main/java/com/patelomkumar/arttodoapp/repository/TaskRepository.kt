package com.patelomkumar.arttodoapp.repository

import androidx.lifecycle.LiveData
import com.patelomkumar.arttodoapp.database.TaskDao
import com.patelomkumar.arttodoapp.model.Task

class TaskRepository(private val taskDao: TaskDao) {

    val ongoingTasks: LiveData<List<Task>> = taskDao.getTasksByStatus("ONGOING")
    val upcomingTasks: LiveData<List<Task>> = taskDao.getTasksByStatus("UPCOMING")
    val finishedTasks: LiveData<List<Task>> = taskDao.getTasksByStatus("FINISHED")

    
    suspend fun insert(task: Task) {
        taskDao.insertTask(task)
    }

    
    suspend fun update(task: Task) {
        taskDao.updateTask(task)
    }

    
    suspend fun delete(task: Task) {
        taskDao.deleteTask(task)
    }

    
    suspend fun deleteById(id: Int) {
        taskDao.deleteTaskById(id)
    }

    
    suspend fun getById(id: Int): Task? {
        return taskDao.getTaskById(id)
    }
}
