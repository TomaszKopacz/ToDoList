package com.example.tomas.mytasks.db

import android.arch.lifecycle.LiveData
import com.example.tomas.mytasks.db.entity.Task

interface TasksRepository {

    fun getAllTasks(): LiveData<List<Task>>
    fun insertTask(task: Task)
    fun updateTask(task: Task)
    fun deleteTask(task: Task)
}