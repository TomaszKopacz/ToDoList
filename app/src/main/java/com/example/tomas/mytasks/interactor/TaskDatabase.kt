package com.example.tomas.mytasks.interactor

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.tomas.mytasks.entity.Task

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun getTaskDao() : TaskDao
}