package com.patelomkumar.arttodoapp.ui.dialog;

/**
 * AddEditTaskDialog — a Material BottomSheetDialogFragment.
 * Used for BOTH adding a new task AND editing an existing one.
 *
 * Open to ADD:   AddEditTaskDialog.newInstance(defaultStatus = "ONGOING").show(...)
 * Open to EDIT:  AddEditTaskDialog.newInstance(taskId = task.id, defaultStatus = task.status).show(...)
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\tH\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J\b\u0010$\u001a\u00020\u0014H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006&"}, d2 = {"Lcom/patelomkumar/arttodoapp/ui/dialog/AddEditTaskDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "_binding", "Lcom/patelomkumar/arttodoapp/databinding/DialogAddEditTaskBinding;", "binding", "getBinding", "()Lcom/patelomkumar/arttodoapp/databinding/DialogAddEditTaskBinding;", "defaultStatus", "", "taskId", "", "viewModel", "Lcom/patelomkumar/arttodoapp/ui/shared/TaskViewModel;", "getViewModel", "()Lcom/patelomkumar/arttodoapp/ui/shared/TaskViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTheme", "loadExistingTask", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onSaveClicked", "onViewCreated", "view", "selectStatus", "status", "setupStatusSpinner", "showDatePicker", "Companion", "app_debug"})
public final class AddEditTaskDialog extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    @org.jetbrains.annotations.Nullable()
    private com.patelomkumar.arttodoapp.databinding.DialogAddEditTaskBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private int taskId = -1;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String defaultStatus = "ONGOING";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "AddEditTaskDialog";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ARG_TASK_ID = "arg_task_id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ARG_STATUS = "arg_status";
    @org.jetbrains.annotations.NotNull()
    public static final com.patelomkumar.arttodoapp.ui.dialog.AddEditTaskDialog.Companion Companion = null;
    
    public AddEditTaskDialog() {
        super();
    }
    
    @java.lang.Override()
    public int getTheme() {
        return 0;
    }
    
    private final com.patelomkumar.arttodoapp.databinding.DialogAddEditTaskBinding getBinding() {
        return null;
    }
    
    private final com.patelomkumar.arttodoapp.ui.shared.TaskViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showDatePicker() {
    }
    
    private final void setupStatusSpinner() {
    }
    
    private final void selectStatus(java.lang.String status) {
    }
    
    private final void loadExistingTask() {
    }
    
    private final void onSaveClicked() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/patelomkumar/arttodoapp/ui/dialog/AddEditTaskDialog$Companion;", "", "()V", "ARG_STATUS", "", "ARG_TASK_ID", "TAG", "newInstance", "Lcom/patelomkumar/arttodoapp/ui/dialog/AddEditTaskDialog;", "taskId", "", "defaultStatus", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.patelomkumar.arttodoapp.ui.dialog.AddEditTaskDialog newInstance(int taskId, @org.jetbrains.annotations.NotNull()
        java.lang.String defaultStatus) {
            return null;
        }
    }
}