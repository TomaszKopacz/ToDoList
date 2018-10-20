package com.example.tomas.mytasks.presenter

import com.example.tomas.mytasks.entity.Task
import com.example.tomas.mytasks.view.TaskView
import java.text.SimpleDateFormat
import java.util.*

class TaskCreatorPresenter(private val view: TaskView, private val listener: OnTaskReadyListener) : TaskCreator {

    var title: String? = null
    var description: String? = null
    var deadline: String? = null
    var priority: Int? = null
    var creationDate: String? = null

    companion object {
        private const val DATE_PATTERN = "dd-MM-yyyy"
    }

    override fun createTask() {
        loadTaskValues()
        val task = prepareTask()
        listener.taskReady(task)
    }

    private fun loadTaskValues() {
        setValuesFromFields()
        setCurrentDate()
    }

    private fun setValuesFromFields() {
        title = view.getTaskTitle()
        description = view.getTaskDescription()
        deadline = view.getTaskDeadline()
        priority = view.getTaskPriority()
    }

    private fun setCurrentDate() {
        val formatter = SimpleDateFormat(DATE_PATTERN, Locale.getDefault())
        creationDate = formatter.format(Date())
    }


    private fun prepareTask(): Task {
        val task = Task()
        task.title = title
        task.description = description
        task.deadline = deadline
        task.priority = priority
        task.creationDate = creationDate

        return task
    }
}