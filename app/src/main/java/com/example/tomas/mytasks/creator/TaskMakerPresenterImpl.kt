package com.example.tomas.mytasks.creator

import com.example.tomas.mytasks.db.entity.Task
import com.example.tomas.mytasks.db.TasksRepository

class TaskMakerPresenterImpl(
    private val view: TaskMakerView,
    private val repository: TasksRepository
) : TaskMakerPresenter {

    private val createdTask = Task()

    override fun onSubmitTaskButtonClicked() {
        createTask()
        insertTask()
        navigateToMainView()
    }

    private fun createTask() {
        getValuesFromViewFields()
    }

    private fun getValuesFromViewFields() {
        createdTask.title = view.getTaskTitle()
        createdTask.description = view.getTaskDescription()
        createdTask.deadline = view.getTaskDeadline()
        createdTask.time = view.getTaskDeadlineTime()
        createdTask.priority = view.getTaskPriority()
    }

    private fun insertTask() {
        repository.insertTask(createdTask)
    }

    private fun navigateToMainView() {
        view.navigateToParentView()
    }
}