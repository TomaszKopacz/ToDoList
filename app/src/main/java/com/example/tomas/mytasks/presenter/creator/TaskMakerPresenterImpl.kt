package com.example.tomas.mytasks.presenter.creator

import com.example.tomas.mytasks.app.MyNotesApp
import com.example.tomas.mytasks.entity.Task
import com.example.tomas.mytasks.interactor.TasksRepository
import com.example.tomas.mytasks.view.creator.TaskMakerView
import javax.inject.Inject

open class TaskMakerPresenterImpl(private val view: TaskMakerView) : TaskMakerPresenter {

    @Inject lateinit var repository: TasksRepository

    private val createdTask = Task()

    init {
        injectDependencies()
    }

    private fun injectDependencies(){
        (view.getContext().applicationContext as MyNotesApp).component.inject(this)
    }

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