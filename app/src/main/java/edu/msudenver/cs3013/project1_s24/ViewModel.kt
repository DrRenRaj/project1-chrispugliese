package edu.msudenver.cs3013.project1_s24

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class TaskViewModel : ViewModel() {

    private val _tasks = MutableLiveData<MutableList<Task>>(mutableListOf())
    val tasks: LiveData<MutableList<Task>> get() = _tasks

    fun addTask(task: Task) {
        _tasks.value?.add(task)
        _tasks.value = _tasks.value
    }
}
