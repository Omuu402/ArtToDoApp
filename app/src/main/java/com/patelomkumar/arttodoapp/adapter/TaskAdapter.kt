package com.patelomkumar.arttodoapp.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.patelomkumar.arttodoapp.R
import com.patelomkumar.arttodoapp.databinding.ItemTaskBinding
import com.patelomkumar.arttodoapp.model.Task

/**
 * RecyclerView Adapter for displaying Task cards.
 * Uses ListAdapter + DiffUtil for efficient, animated list updates.
 */
class TaskAdapter(
    private val onEditClick: (Task) -> Unit,
    private val onDeleteClick: (Task) -> Unit
) : ListAdapter<Task, TaskAdapter.TaskViewHolder>(DIFF_CALLBACK) {

    inner class TaskViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(task: Task) {
            // Title
            binding.tvTaskTitle.text = task.title

            // Medium — hide if blank
            if (task.medium.isNotBlank()) {
                binding.tvTaskMedium.visibility = View.VISIBLE
                binding.tvTaskMedium.text = task.medium
            } else {
                binding.tvTaskMedium.visibility = View.GONE
            }

            // Description
            binding.tvTaskDescription.text =
                if (task.description.isNotBlank()) task.description else "No description added."

            // Due date — hide if blank
            if (task.dueDate.isNotBlank()) {
                binding.tvTaskDate.visibility = View.VISIBLE
                binding.tvTaskDate.text = "📅  ${task.dueDate}"
            } else {
                binding.tvTaskDate.visibility = View.GONE
            }

            // Status dot & medium colour based on task status
            val colorRes = when (task.status.uppercase()) {
                "UPCOMING" -> R.color.upcoming_color
                "FINISHED" -> R.color.finished_color
                else       -> R.color.ongoing_color   // default = ONGOING
            }
            val color = ContextCompat.getColor(binding.root.context, colorRes)
            binding.viewStatusDot.backgroundTintList = ColorStateList.valueOf(color)
            binding.tvTaskMedium.setTextColor(color)

            // Buttons
            binding.btnEdit.setOnClickListener { onEditClick(task) }
            binding.btnDelete.setOnClickListener { onDeleteClick(task) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Task>() {
            override fun areItemsTheSame(oldItem: Task, newItem: Task) =
                oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Task, newItem: Task) =
                oldItem == newItem
        }
    }
}
