package com.example.tomas.mytasks.data

import android.app.Application
import android.arch.lifecycle.LiveData
import com.example.tomas.mytasks.entity.Task
import com.example.tomas.mytasks.interactor.TaskDao
import com.example.tomas.mytasks.interactor.TaskDatabase

class TasksRepository (app: Application) {

    private val tasksDao: TaskDao

    init {
        val tasksDatabase = TaskDatabase.getInstance(app)
        tasksDao = tasksDatabase.getTaskDao()
    }

    fun getAllTasks(): LiveData<List<Task>> {
        return tasksDao.getAll()
    }

    fun insertTask(task: Task) {
        tasksDao.insert(task)
    }
}