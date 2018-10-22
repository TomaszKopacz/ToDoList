package com.example.tomas.mytasks.utils

import com.example.tomas.mytasks.entity.Task
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TaskSorterTest {

    private lateinit var task1: Task
    private lateinit var task2: Task
    private lateinit var task3: Task
    private lateinit var task4: Task

    @Before
    fun init() {
        task1 = Task()
        task2 = Task()
        task3 = Task()
        task4 = Task()

        task1.creationDate = "01-01-2010"
        task1.deadline = "31-01-2010"
        task1.priority = 8

        task2.creationDate = "01-01-2010"
        task2.deadline = "31-12-2025"
        task2.priority = 4

        task3.creationDate = "02-01-2010"
        task3.deadline = "31-12-2025"
        task3.priority = 1

        task4.creationDate = "03-01-2010"
        task4.deadline = "01-06-2015"
        task4.priority = 1
    }

    @Test
    fun checkSortWhenOneFieldIsSetAtPrimary(){
        val testArray = arrayOf(task1, task2, task3, task4)
        val correctArray = arrayOf(task4, task3, task2, task1)

        val sorter = TaskSorter()
        sorter.setPrimaryField(TaskSorter.PRIORITY)

        val sortedArray = sorter.sort(testArray)
        assertEquals(correctArray, sortedArray)
        assertEquals(correctArray[0].priority, sortedArray[0].priority)
        assertEquals(correctArray[1].priority, sortedArray[1].priority)
        assertEquals(correctArray[2].priority, sortedArray[2].priority)
        assertEquals(correctArray[3].priority, sortedArray[3].priority)
    }

    @Test
    fun checkSortWhenOneFieldIsSetAtSecondary(){
        val testArray = arrayOf(task1, task2, task3, task4)
        val correctArray = arrayOf(task4, task3, task2, task1)

        val sorter = TaskSorter()
        sorter.setSecondaryField(TaskSorter.PRIORITY)

        val sortedArray = sorter.sort(testArray)
        assertEquals(correctArray, sortedArray)
    }

    @Test
    fun checkSortWhenOneFieldIsSetAtThird(){
        val testArray = arrayOf(task1, task2, task3, task4)
        val correctArray = arrayOf(task4, task3, task2, task1)

        val sorter = TaskSorter()
        sorter.setThirdField(TaskSorter.PRIORITY)

        val sortedArray = sorter.sort(testArray)
        assertEquals(correctArray, sortedArray)
    }

    @Test
    fun checkSortWhenTwoFieldsAreSetAtPrimaryAndSecondary(){
        val testArray = arrayOf(task1, task2, task3, task4)
        val correctArray = arrayOf(task3, task4, task2, task1)

        val sorter = TaskSorter()
        sorter.setPrimaryField(TaskSorter.PRIORITY)
        sorter.setSecondaryField(TaskSorter.DEADLINE)

        val sortedArray = sorter.sort(testArray)
        assertEquals(correctArray, sortedArray)
    }

    @Test
    fun checkSortWhenTwoFieldsAreSetAtPrimaryAndThird(){
        val testArray = arrayOf(task1, task2, task3, task4)
        val correctArray = arrayOf(task3, task2, task4, task1)

        val sorter = TaskSorter()
        sorter.setPrimaryField(TaskSorter.DEADLINE)
        sorter.setThirdField(TaskSorter.PRIORITY)

        val sortedArray = sorter.sort(testArray)
        assertEquals(correctArray, sortedArray)
        assertEquals(correctArray[0].priority, sortedArray[0].priority)
        assertEquals(correctArray[1].priority, sortedArray[1].priority)
        assertEquals(correctArray[2].priority, sortedArray[2].priority)
        assertEquals(correctArray[3].priority, sortedArray[3].priority)
    }

    @Test
    fun checkSortWhenTwoFieldsAreSetAtSecondaryAndThird(){
        val testArray = arrayOf(task1, task2, task3, task4)
        val correctArray = arrayOf(task4, task3, task2, task1)

        val sorter = TaskSorter()
        sorter.setSecondaryField(TaskSorter.CREATION_DATE)
        sorter.setThirdField(TaskSorter.PRIORITY)

        val sortedArray = sorter.sort(testArray)
        assertEquals(correctArray, sortedArray)
    }

    @Test
    fun checkSortWhenThreeFieldsAreSet(){
        val testArray = arrayOf(task1, task2, task3, task4)
        val correctArray = arrayOf(task3, task2, task4, task1)

        val sorter = TaskSorter()
        sorter.setPrimaryField(TaskSorter.DEADLINE)
        sorter.setSecondaryField(TaskSorter.CREATION_DATE)
        sorter.setThirdField(TaskSorter.PRIORITY)

        val sortedArray = sorter.sort(testArray)
        assertEquals(correctArray, sortedArray)
        assertEquals(correctArray[0].priority, sortedArray[0].priority)
        assertEquals(correctArray[1].priority, sortedArray[1].priority)
        assertEquals(correctArray[2].priority, sortedArray[2].priority)
        assertEquals(correctArray[3].priority, sortedArray[3].priority)
    }

    @Test
    fun checkSortWhenThreeFieldsAreSetAtSamePosition(){
        val testArray = arrayOf(task1, task2, task3, task4)
        val correctArray = arrayOf(task4, task3, task2, task1)

        val sorter = TaskSorter()
        sorter.setSecondaryField(TaskSorter.DEADLINE)
        sorter.setSecondaryField(TaskSorter.CREATION_DATE)
        sorter.setSecondaryField(TaskSorter.PRIORITY)

        val sortedArray = sorter.sort(testArray)
        assertEquals(correctArray, sortedArray)
    }

    @Test
    fun checkSortWhenNoneOfFieldsIsSet(){
        val testArray = arrayOf(task1, task2, task3, task4)
        val correctArray = arrayOf(task1, task2, task3, task4)

        val sorter = TaskSorter()

        val sortedArray = sorter.sort(testArray)
        assertEquals(correctArray, sortedArray)
    }
}