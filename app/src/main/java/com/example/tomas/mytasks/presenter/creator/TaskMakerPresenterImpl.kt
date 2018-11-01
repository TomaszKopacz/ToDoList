package com.example.tomas.mytasks.presenter.creator

import android.content.Intent
import com.example.tomas.mytasks.app.MyNotesApp
import com.example.tomas.mytasks.entity.Task
import com.example.tomas.mytasks.utils.DatePatterns
import com.example.tomas.mytasks.view.board.BoardActivity
import com.example.tomas.mytasks.view.creator.TaskMakerView
import java.text.SimpleDateFormat
import java.util.*

class TaskMakerPresenterImpl(private val view: TaskMakerView) : TaskMakerPresenter {

    private val createdTask = Task()

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
        val tasksRepository = (view.getContext().applicationContext as MyNotesApp).getTasksRepository()
        tasksRepository.insertTask(createdTask)
    }

    private fun navigateToMainView() {
        view.navigateToParentView()
    }
}