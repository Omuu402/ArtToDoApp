package com.patelomkumar.arttodoapp.ui.shared;

/**
 * ViewModelFactory — required because TaskViewModel has a constructor parameter (repository).
 *
 * Android cannot create a ViewModel with constructor args on its own,
 * so we provide this factory to tell it how to build TaskViewModel.
 *
 * Usage in a Fragment:
 *  val viewModel: TaskViewModel by viewModels { TaskViewModelFactory(repository) }
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/patelomkumar/arttodoapp/ui/shared/TaskViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "repository", "Lcom/patelomkumar/arttodoapp/repository/TaskRepository;", "(Lcom/patelomkumar/arttodoapp/repository/TaskRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
public final class TaskViewModelFactory implements androidx.lifecycle.ViewModelProvider.Factory {
    @org.jetbrains.annotations.NotNull()
    private final com.patelomkumar.arttodoapp.repository.TaskRepository repository = null;
    
    public TaskViewModelFactory(@org.jetbrains.annotations.NotNull()
    com.patelomkumar.arttodoapp.repository.TaskRepository repository) {
        super();
    }
    
    @java.lang.Override()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @org.jetbrains.annotations.NotNull()
    public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> modelClass) {
        return null;
    }
}