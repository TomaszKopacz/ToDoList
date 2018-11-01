package com.example.tomas.mytasks.app

import android.app.Application
import com.example.tomas.mytasks.data.TasksRepository

class MyNotesApp : Application() {

    fun getTasksRepository() = TasksRepository(this)
}