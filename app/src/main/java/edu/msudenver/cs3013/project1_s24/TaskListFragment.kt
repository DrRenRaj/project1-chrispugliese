package edu.msudenver.cs3013.project1_s24

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController

class TaskListFragment : Fragment() {

    private lateinit var taskViewModel: TaskViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_task_list, container, false)
        (activity as MainActivity).setToolbarTitle("Tasks")


        taskViewModel = ViewModelProvider(requireActivity()).get(TaskViewModel::class.java)

        recyclerView = view.findViewById(R.id.recycler_view_tasks)
        recyclerView.layoutManager = LinearLayoutManager(context)

        taskViewModel.tasks.observe(viewLifecycleOwner) { tasks ->
            taskAdapter = TaskAdapter(tasks)
            recyclerView.adapter = taskAdapter
        }

        val addButton: Button = view.findViewById(R.id.button_add_task)
        addButton.setOnClickListener {
            findNavController().navigate(R.id.action_taskListFragment_to_addTaskFragment)
        }

        return view
    }
}
