package com.example.tomas.mytasks.db

import android.arch.lifecycle.LiveData
import com.example.tomas.mytasks.db.entity.Task

class TasksRepository (private val taskDao: TaskDao) {

    fun getAllTasks(): LiveData<List<Task>> {
        return taskDao.getAll()
    }

    fun insertTask(task: Task) {
        taskDao.insert(task)
    }
    fun updateTask(task: Task){
        taskDao.update(task)
    }

    fun deleteTask(task: Task) {
        taskDao.delete(task)
    }
}