package com.example.tomas.mytasks.di

import android.app.Application
import android.arch.persistence.room.Room
import com.example.tomas.mytasks.interactor.TaskDao
import com.example.tomas.mytasks.interactor.TaskDatabase
import com.example.tomas.mytasks.interactor.TasksRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val app: Application) {

    private val db: TaskDatabase = Room.databaseBuilder(app, TaskDatabase::class.java, TaskDatabase.DATABASE_NAME)
        .allowMainThreadQueries()
        .build()

    @Singleton
    @Provides
    fun providesTaskDatabase(): TaskDatabase {
        return db
    }

    @Singleton
    @Provides
    fun providesTaskDao(): TaskDao {
        return db.getTaskDao()
    }

    @Singleton
    @Provides
    fun providesTasksRepository(taskDao: TaskDao): TasksRepository {
        return TasksRepository(taskDao)
    }
}