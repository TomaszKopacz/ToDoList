package com.example.tomas.mytasks.db

import android.arch.lifecycle.LiveData
import com.example.tomas.mytasks.db.entity.Task

class TasksRepositoryImpl (private val taskDao: TaskDao) : TasksRepository {

    override fun getAllTasks(): LiveData<List<Task>> {
        return taskDao.getAll()
    }

    override fun insertTask(task: Task) {
        taskDao.insert(task)
    }
    override fun updateTask(task: Task){
        taskDao.update(task)
    }

    override fun deleteTask(task: Task) {
        taskDao.delete(task)
    }
}