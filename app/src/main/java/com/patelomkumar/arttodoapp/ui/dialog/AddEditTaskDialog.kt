package com.patelomkumar.arttodoapp.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.patelomkumar.arttodoapp.R
import com.patelomkumar.arttodoapp.database.TaskDatabase
import com.patelomkumar.arttodoapp.databinding.DialogAddEditTaskBinding
import com.patelomkumar.arttodoapp.model.Task
import com.patelomkumar.arttodoapp.repository.TaskRepository
import com.patelomkumar.arttodoapp.ui.shared.TaskViewModel
import com.patelomkumar.arttodoapp.ui.shared.TaskViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

/**
 * AddEditTaskDialog — a Material BottomSheetDialogFragment.
 * Used for BOTH adding a new task AND editing an existing one.
 *
 * Open to ADD:   AddEditTaskDialog.newInstance(defaultStatus = "ONGOING").show(...)
 * Open to EDIT:  AddEditTaskDialog.newInstance(taskId = task.id, defaultStatus = task.status).show(...)
 */
class AddEditTaskDialog : BottomSheetDialogFragment() {
    
    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    private var _binding: DialogAddEditTaskBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TaskViewModel by activityViewModels {
        val db = TaskDatabase.getDatabase(requireContext())
        TaskViewModelFactory(TaskRepository(db.taskDao()))
    }

    private var taskId: Int = -1
    private var defaultStatus: String = "ONGOING"

    companion object {
        const val TAG = "AddEditTaskDialog"
        private const val ARG_TASK_ID = "arg_task_id"
        private const val ARG_STATUS  = "arg_status"

        fun newInstance(taskId: Int = -1, defaultStatus: String = "ONGOING") =
            AddEditTaskDialog().apply {
                arguments = Bundle().apply {
                    putInt(ARG_TASK_ID, taskId)
                    putString(ARG_STATUS, defaultStatus)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogAddEditTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskId        = arguments?.getInt(ARG_TASK_ID, -1) ?: -1
        defaultStatus = arguments?.getString(ARG_STATUS) ?: "ONGOING"

        setupStatusSpinner()

        if (taskId != -1) {
            binding.tvDialogTitle.text = getString(R.string.dialog_title_edit)
            loadExistingTask()
        } else {
            binding.tvDialogTitle.text = getString(R.string.dialog_title_add)
            selectStatus(defaultStatus)
        }

        binding.btnSave.setOnClickListener   { onSaveClicked() }
        binding.btnCancel.setOnClickListener { dismiss() }
        
        // Date Picker setup
        binding.etDueDate.setOnClickListener { showDatePicker() }
        binding.etDueDate.isFocusable = false
        binding.etDueDate.isClickable = true
    }

    private fun showDatePicker() {
        val picker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select Due Date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()

        picker.addOnPositiveButtonClickListener { selection ->
            val date = Date(selection)
            val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            binding.etDueDate.setText(format.format(date))
        }
        picker.show(parentFragmentManager, "DATE_PICKER")
    }

    private fun setupStatusSpinner() {
        val options = resources.getStringArray(R.array.status_options)
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            options
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerStatus.adapter = adapter
    }

    private fun selectStatus(status: String) {
        val options = resources.getStringArray(R.array.status_options)
        val index = options.indexOfFirst { it.equals(status, ignoreCase = true) }
        if (index >= 0) binding.spinnerStatus.setSelection(index)
    }

    private fun loadExistingTask() {
        viewModel.getTaskById(taskId).observe(viewLifecycleOwner) { task ->
            task ?: return@observe
            binding.etTitle.setText(task.title)
            binding.etMedium.setText(task.medium)
            binding.etDescription.setText(task.description)
            binding.etDueDate.setText(task.dueDate)
            selectStatus(task.status)
        }
    }

    private fun onSaveClicked() {
        val title = binding.etTitle.text.toString().trim()
        if (title.isEmpty()) {
            binding.etTitle.error = "Title is required"
            return
        }

        val status = binding.spinnerStatus.selectedItem.toString().uppercase()
        val task = Task(
            id          = if (taskId == -1) 0 else taskId,
            title       = title,
            medium      = binding.etMedium.text.toString().trim(),
            description = binding.etDescription.text.toString().trim(),
            dueDate     = binding.etDueDate.text.toString().trim(),
            status      = status
        )

        if (taskId == -1) {
            viewModel.insertTask(task)
            Toast.makeText(requireContext(), "Work added!", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.updateTask(task)
            Toast.makeText(requireContext(), "Work updated!", Toast.LENGTH_SHORT).show()
        }
        dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
