package edu.msudenver.cs3013.project1_s24

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class TaskDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_task_detail, container, false)

        val taskTitle = view.findViewById<TextView>(R.id.task_title)
        val taskDescription = view.findViewById<TextView>(R.id.task_description)


        taskTitle.text = arguments?.getString("taskTitle")
        taskDescription.text = arguments?.getString("taskDescription")

        return view
    }
}