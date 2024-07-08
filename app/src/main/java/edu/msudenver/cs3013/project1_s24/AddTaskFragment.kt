package edu.msudenver.cs3013.project1_s24

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class AddTaskFragment : Fragment() {

    private lateinit var taskTitleInput: EditText
    private lateinit var taskDescriptionInput: EditText
    private lateinit var saveButton: Button
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)
        (activity as MainActivity).setToolbarTitle("Add Task")

        taskTitleInput = view.findViewById(R.id.task_title_input)
        taskDescriptionInput = view.findViewById(R.id.task_description_input)
        saveButton = view.findViewById(R.id.button_save_task)

        taskViewModel = ViewModelProvider(requireActivity()).get(TaskViewModel::class.java)

        saveButton.setOnClickListener {
            val taskTitle = taskTitleInput.text.toString()
            val taskDescription = taskDescriptionInput.text.toString()

            if (taskTitle.isNotEmpty() && taskDescription.isNotEmpty()) {
                val task = Task(taskTitle, taskDescription)
                taskViewModel.addTask(task)
                findNavController().navigate(R.id.action_addTaskFragment_to_taskListFragment)
            }
        }

        return view
    }
}
