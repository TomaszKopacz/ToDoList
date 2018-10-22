package com.example.tomas.mytasks.presenter

import com.example.tomas.mytasks.entity.Task
import com.example.tomas.mytasks.utils.DatePatterns
import com.example.tomas.mytasks.view.TaskView
import java.text.SimpleDateFormat
import java.util.*

class TaskCreatorPresenter(private val view: TaskView, private val listener: OnTaskReadyListener?) : TaskModifier {

    var title: String? = null
    var description: String? = null
    var deadline: String? = null
    var priority: Int? = null
    var creationDate: String? = null

    companion object {
        private const val DATE_PATTERN = DatePatterns.DD_MM_YYYY_DASHES
    }

    override fun createTask() {
        assignTaskValues()
        listener?.taskReady(prepareTask())
    }

    override fun loadTask(task: Task?) {
        if (task == null)
            return
        else {
            view.setTaskTitle(task.title)
            view.setTaskDescription(task.description)
            view.setTaskDeadline(task.deadline)
            view.setTaskPriority(task.priority)
        }
    }

    private fun assignTaskValues() {
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