package com.example.tomas.mytasks.interactor

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.tomas.mytasks.entity.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getAll() : List<Task>

//    @Query("SELECT * FROM task WHERE id = :id LIMIT 1")
//    fun getById(id : Int)

    @Insert
    fun insert(task: Task)

//    @Query("")
//    fun modify(oldTask: Task, newTask: Task)

    @Delete
    fun delete(task: Task)
}