package com.example.tomas.mytasks.presenter.creator

import com.example.tomas.mytasks.app.MyNotesApp
import com.example.tomas.mytasks.entity.Task
import com.example.tomas.mytasks.interactor.TasksRepository
import com.example.tomas.mytasks.utils.DatePatterns
import com.example.tomas.mytasks.view.creator.TaskMakerView
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class TaskMakerPresenterImpl(private val view: TaskMakerView) : TaskMakerPresenter {

    @Inject lateinit var repository: TasksRepository

    private val createdTask = Task()

    init {
        (view.getContext().applicationContext as MyNotesApp).component.inject(this)
    }

    override fun onSubmitTaskButtonClicked() {
        createTask()
        insertTask()
        navigateToMainView()
    }

    private fun createTask() {
        getValuesFromViewFields()
        setCreationDate()
    }

    private fun getValuesFromViewFields() {
        createdTask.title = view.getTaskTitle()
        createdTask.description = view.getTaskDescription()
        createdTask.deadline = view.getTaskDeadline()
        createdTask.priority = view.getTaskPriority()
    }

    private fun setCreationDate() {
        val formatter = SimpleDateFormat(DatePatterns.DD_MM_YYYY_DASHES, Locale.getDefault())
        createdTask.creationDate = formatter.format(Date())
    }

    private fun insertTask() {
        repository.insertTask(createdTask)
    }

    private fun navigateToMainView() {
        view.navigateToParentView()
    }
}