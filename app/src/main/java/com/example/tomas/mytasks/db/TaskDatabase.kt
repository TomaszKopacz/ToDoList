package com.example.tomas.mytasks.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.tomas.mytasks.db.entity.Task

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    companion object {
        const val DATABASE_NAME = "tasks_db"
    }
}