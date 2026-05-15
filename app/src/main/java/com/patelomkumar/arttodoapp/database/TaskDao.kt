package com.patelomkumar.arttodoapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.patelomkumar.arttodoapp.model.Task

@Dao
interface TaskDao {

    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    
    @Query("SELECT * FROM tasks WHERE status = :status ORDER BY id DESC")
    fun getTasksByStatus(status: String): LiveData<List<Task>>

    
    @Query("SELECT * FROM tasks WHERE id = :id LIMIT 1")
    suspend fun getTaskById(id: Int): Task?

    
    @Update
    suspend fun updateTask(task: Task)

    
    @Delete
    suspend fun deleteTask(task: Task)

    
    @Query("DELETE FROM tasks WHERE id = :id")
    suspend fun deleteTaskById(id: Int)
}
