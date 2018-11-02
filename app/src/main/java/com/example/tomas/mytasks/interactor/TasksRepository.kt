package com.example.tomas.mytasks.interactor

import android.arch.lifecycle.LiveData
import com.example.tomas.mytasks.entity.Task

class TasksRepository (private val taskDao: TaskDao) {

    fun getAllTasks(): LiveData<List<Task>> {
        return taskDao.getAll()
    }

    fun insertTask(task: Task) {
        taskDao.insert(task)
    }

    fun deleteTask(task: Task) {
        taskDao.delete(task)
    }
}