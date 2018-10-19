package com.example.tomas.mytasks.presenter

import com.example.tomas.mytasks.entity.Task
import com.example.tomas.mytasks.view.TaskView

interface TaskCreator {
    fun createTask()
    fun modifyTask(task: Task)
    fun submitTask(view: TaskView)
}
