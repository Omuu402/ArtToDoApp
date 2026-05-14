package com.patelomkumar.arttodoapp.database;

/**
 * Data Access Object — all CRUD operations for the Task table.
 *
 * Room generates the SQL automatically from these annotations.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\'J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/patelomkumar/arttodoapp/database/TaskDao;", "", "deleteTask", "", "task", "Lcom/patelomkumar/arttodoapp/model/Task;", "(Lcom/patelomkumar/arttodoapp/model/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTaskById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTaskById", "getTasksByStatus", "Landroidx/lifecycle/LiveData;", "", "status", "", "insertTask", "updateTask", "app_debug"})
@androidx.room.Dao()
public abstract interface TaskDao {
    
    /**
     * Insert a new task. If a task with the same ID somehow exists, replace it.
     */
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTask(@org.jetbrains.annotations.NotNull()
    com.patelomkumar.arttodoapp.model.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Get all tasks whose status matches the given value.
     * Returns LiveData so the UI updates automatically when data changes.
     *
     * @param status  "ONGOING", "UPCOMING", or "FINISHED"
     */
    @androidx.room.Query(value = "SELECT * FROM tasks WHERE status = :status ORDER BY id DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.patelomkumar.arttodoapp.model.Task>> getTasksByStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String status);
    
    /**
     * Get a single task by its ID (used when opening the edit dialog).
     */
    @androidx.room.Query(value = "SELECT * FROM tasks WHERE id = :id LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTaskById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.patelomkumar.arttodoapp.model.Task> $completion);
    
    /**
     * Update an existing task (matched by primary key).
     */
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateTask(@org.jetbrains.annotations.NotNull()
    com.patelomkumar.arttodoapp.model.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Delete a specific task.
     */
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTask(@org.jetbrains.annotations.NotNull()
    com.patelomkumar.arttodoapp.model.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Delete a task directly by its ID.
     */
    @androidx.room.Query(value = "DELETE FROM tasks WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTaskById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}