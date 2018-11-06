package com.example.tomas.mytasks.creator

import android.content.Context
import com.example.tomas.mytasks.creator.TaskMakerPresenter

interface TaskMakerView {

    fun setPresenter(taskMakerPresenter: TaskMakerPresenter)
    fun getContext() : Context

    fun getTaskTitle() : String
    fun getTaskDescription() : String
    fun getTaskDeadline() : String
    fun getTaskDeadlineTime() : String
    fun getTaskPriority() : Int

    fun setTaskTitle(title : String?)
    fun setTaskDescription(description : String?)
    fun setTaskDeadline(deadline : String?)
    fun setTaskDeadlineTime(time : String?)
    fun setTaskPriority(priority : Int?)

    fun navigateToParentView()
}