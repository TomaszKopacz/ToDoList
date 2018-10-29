package com.example.tomas.mytasks.presenter

import com.example.tomas.mytasks.entity.Task

interface TaskModifier {
    fun modifyTask(task: Task, id: Int, listener: OnTaskReadyListener)
}