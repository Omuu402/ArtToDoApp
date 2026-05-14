package com.patelomkumar.arttodoapp.ui.ongoing

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.patelomkumar.arttodoapp.adapter.TaskAdapter
import com.patelomkumar.arttodoapp.database.TaskDatabase
import com.patelomkumar.arttodoapp.databinding.FragmentOngoingBinding
import com.patelomkumar.arttodoapp.repository.TaskRepository
import com.patelomkumar.arttodoapp.ui.dialog.AddEditTaskDialog
import com.patelomkumar.arttodoapp.ui.shared.TaskViewModel
import com.patelomkumar.arttodoapp.ui.shared.TaskViewModelFactory

class OngoingFragment : Fragment() {

    private var _binding: FragmentOngoingBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TaskViewModel by activityViewModels {
        val db = TaskDatabase.getDatabase(requireActivity().applicationContext)
        TaskViewModelFactory(TaskRepository(db.taskDao()))
    }

    private lateinit var adapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOngoingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            setupRecyclerView()
            observeTasks()
            binding.fabAddTask.setOnClickListener {
                AddEditTaskDialog.newInstance(defaultStatus = "ONGOING")
                    .show(parentFragmentManager, AddEditTaskDialog.TAG)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            android.widget.Toast.makeText(requireContext(), "FRAG CRASH: ${e.message}", android.widget.Toast.LENGTH_LONG).show()
        }
    }

    private fun setupRecyclerView() {
        adapter = TaskAdapter(
            onEditClick = { task ->
                AddEditTaskDialog.newInstance(taskId = task.id, defaultStatus = task.status)
                    .show(parentFragmentManager, AddEditTaskDialog.TAG)
            },
            onDeleteClick = { task ->
                AlertDialog.Builder(requireContext())
                    .setTitle("Delete this work?")
                    .setMessage("\"${task.title}\" will be permanently removed.")
                    .setPositiveButton("Delete") { _, _ -> viewModel.deleteTask(task) }
                    .setNegativeButton("Cancel", null)
                    .show()
            }
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    private fun observeTasks() {
        viewModel.ongoingTasks.observe(viewLifecycleOwner) { tasks ->
            adapter.submitList(tasks)
            binding.recyclerView.visibility = if (tasks.isEmpty()) View.GONE else View.VISIBLE
            binding.layoutEmpty.visibility  = if (tasks.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
