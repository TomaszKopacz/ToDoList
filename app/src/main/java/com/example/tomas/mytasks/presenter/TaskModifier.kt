package com.example.tomas.mytasks.presenter

import com.example.tomas.mytasks.entity.Task

interface TaskModifier {

    fun loadTask(task: Task?)
    fun createTask()
}
