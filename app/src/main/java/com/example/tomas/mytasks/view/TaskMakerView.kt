package com.example.tomas.mytasks.view

import android.content.Context
import com.example.tomas.mytasks.presenter.TaskMakerPresenter

interface TaskMakerView {

    fun getContext() : Context
    fun setPresenter(presenter: TaskMakerPresenter)

    fun getTaskTitle() : String
    fun getTaskDescription() : String
    fun getTaskDeadline() : String
    fun getTaskPriority() : Int

    fun setTaskTitle(title : String?)
    fun setTaskDescription(description : String?)
    fun setTaskDeadline(deadline : String?)
    fun setTaskPriority(priority : Int?)
}