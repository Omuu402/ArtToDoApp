package com.patelomkumar.arttodoapp.ui.shared;

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
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/patelomkumar/arttodoapp/ui/shared/TaskViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/patelomkumar/arttodoapp/repository/TaskRepository;", "(Lcom/patelomkumar/arttodoapp/repository/TaskRepository;)V", "finishedTasks", "Landroidx/lifecycle/LiveData;", "", "Lcom/patelomkumar/arttodoapp/model/Task;", "getFinishedTasks", "()Landroidx/lifecycle/LiveData;", "ongoingTasks", "getOngoingTasks", "upcomingTasks", "getUpcomingTasks", "deleteTask", "Lkotlinx/coroutines/Job;", "task", "deleteTaskById", "id", "", "getTaskById", "insertTask", "updateTask", "app_debug"})
public final class TaskViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.patelomkumar.arttodoapp.repository.TaskRepository repository = null;
    
    /**
     * Tasks currently being worked on
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.patelomkumar.arttodoapp.model.Task>> ongoingTasks = null;
    
    /**
     * Tasks planned but not started yet
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.patelomkumar.arttodoapp.model.Task>> upcomingTasks = null;
    
    /**
     * Tasks that have been completed
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.patelomkumar.arttodoapp.model.Task>> finishedTasks = null;
    
    public TaskViewModel(@org.jetbrains.annotations.NotNull()
    com.patelomkumar.arttodoapp.repository.TaskRepository repository) {
        super();
    }
    
    /**
     * Tasks currently being worked on
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.patelomkumar.arttodoapp.model.Task>> getOngoingTasks() {
        return null;
    }
    
    /**
     * Tasks planned but not started yet
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.patelomkumar.arttodoapp.model.Task>> getUpcomingTasks() {
        return null;
    }
    
    /**
     * Tasks that have been completed
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.patelomkumar.arttodoapp.model.Task>> getFinishedTasks() {
        return null;
    }
    
    /**
     * Insert a brand-new task into the database.
     * viewModelScope ensures this is cancelled if the ViewModel is destroyed.
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insertTask(@org.jetbrains.annotations.NotNull()
    com.patelomkumar.arttodoapp.model.Task task) {
        return null;
    }
    
    /**
     * Update an existing task (e.g. after the user edits it).
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateTask(@org.jetbrains.annotations.NotNull()
    com.patelomkumar.arttodoapp.model.Task task) {
        return null;
    }
    
    /**
     * Delete a task by passing the full Task object.
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteTask(@org.jetbrains.annotations.NotNull()
    com.patelomkumar.arttodoapp.model.Task task) {
        return null;
    }
    
    /**
     * Delete a task when you only have its ID (from the RecyclerView adapter).
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteTaskById(int id) {
        return null;
    }
    
    /**
     * Fetch a single task by ID — used to populate the Edit dialog.
     * Returns the task inside a new LiveData so the caller can observe it.
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.patelomkumar.arttodoapp.model.Task> getTaskById(int id) {
        return null;
    }
}