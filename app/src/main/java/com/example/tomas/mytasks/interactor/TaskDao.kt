package com.example.tomas.mytasks.interactor

import android.arch.persistence.room.*
import com.example.tomas.mytasks.entity.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getAll() : List<Task>

    @Query("SELECT * FROM task WHERE id LIKE (:id) LIMIT 1")
    fun getById(id : Int) : Task

    @Insert
    fun insert(task: Task)

    @Update
    fun update(task: Task)

    @Delete
    fun delete(task: Task)
}