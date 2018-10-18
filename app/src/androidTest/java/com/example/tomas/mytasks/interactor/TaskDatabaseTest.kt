package com.example.tomas.mytasks.interactor

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import com.example.tomas.mytasks.entity.Task
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TaskDatabaseTest {
    private var taskDao : TaskDao? = null
    private var taskDb : TaskDatabase? = null

    companion object {
        const val TITLE = "TITLE"
        const val CREATION = "01-01.2000"
        const val DESCRIPTION = "DESCRIPTION"
        const val TERMINATION = "31-12-2020"
        const val PRIORITY = 8
    }

    @Before
    fun createDb(){
        val context = InstrumentationRegistry.getTargetContext()
        taskDb = Room.inMemoryDatabaseBuilder(context, TaskDatabase::class.java).build()
        taskDao = taskDb!!.getTaskDao()
    }

    @After
    fun closeDb(){
        taskDb?.close()
    }

    @Test
    fun testWriteAndGetAll(){
        val task = Task()
        task.title = TITLE
        task.creationDate = CREATION
        task.description = DESCRIPTION
        task.mustToDoDate = TERMINATION
        task.priority = PRIORITY

        taskDao!!.insert(task)
        assertTrue(taskDao!!.getAll().size == 1)

        val dbTask = taskDao!!.getAll()[0]
        assertTrue(dbTask.id == 1)
        assertTrue(dbTask.title == TITLE)
        assertTrue(dbTask.creationDate == CREATION)
        assertTrue(dbTask.description == DESCRIPTION)
        assertTrue(dbTask.mustToDoDate == TERMINATION)
        assertTrue(dbTask.priority == PRIORITY)
    }
}