package com.example.tomas.mytasks.utils

import com.example.tomas.mytasks.entity.Task
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TaskSorterTest {

    private lateinit var tasksToSort: ArrayList<Task>
    private lateinit var task1: Task
    private lateinit var task2: Task
    private lateinit var task3: Task
    private lateinit var task4: Task

    @Before
    fun init() {
        tasksToSort = ArrayList()

        task1 = Task()
        task2 = Task()
        task3 = Task()
        task4 = Task()

        task1.creationDate = "01-01-2010"
        task1.deadline = "31-01-2010"
        task1.priority = 1

        task2.creationDate = "01-01-2010"
        task2.deadline = "31-12-2020"
        task2.priority = 2

        task3.creationDate = "02-01-2010"
        task3.deadline = "31-12-2020"
        task3.priority = 3

        task4.creationDate = "03-01-2010"
        task4.deadline = "01-06-2015"
        task4.priority = 4

        tasksToSort.add(task1)
        tasksToSort.add(task2)
        tasksToSort.add(task3)
        tasksToSort.add(task4)
    }

    @Test
    fun testQuickSort() {
        val arr = arrayOf(task1, task2, task3, task4)
        val correct = arrayOf(task4, task3, task2, task1)

        val sorter = TaskSorter()
        val sortedArr = sorter.sort(arr)

        assertEquals(correct[0].priority, sortedArr[0].priority)
        assertEquals(correct[1].priority, sortedArr[1].priority)
        assertEquals(correct[2].priority, sortedArr[2].priority)
        assertEquals(correct[3].priority, sortedArr[3].priority)
    }

//    @Test
//    fun checkPriorityAsPrimary(){
//        val sorter = TaskSorter()
//        sorter.setPrimaryField(TaskSorter.PRIORITY)
//
//        val correctList = ArrayList<Task>()
//        correctList.add(task4)
//        correctList.add(task3)
//        correctList.add(task2)
//        correctList.add(task1)
//
//        val sortedTasks = sorter.sort(tasksToSort)
//        assertEquals(correctList, sortedTasks)
//    }
//
//    @Test
//    fun checkSortWhenOneFieldIsSetAtPrimary(){
//        val sorter = TaskSorter()
//        sorter.setPrimaryField(TaskSorter.PRIORITY)
//
//        val correctList = ArrayList<Task>()
//        correctList.add(task2)
//        correctList.add(task4)
//        correctList.add(task3)
//        correctList.add(task1)
//
//        assertEquals(4, tasksToSort.size)
//
//        val sortedTasks = sorter.sort(tasksToSort)
//        assertEquals(correctList, sortedTasks)
//    }
//
//    @Test
//    fun checkSortWhenOneFieldIsSetAtSecondary(){
//        val sorter = TaskSorter()
//        sorter.setSecondaryField(TaskSorter.PRIORITY)
//
//        val correctList = ArrayList<Task>()
//        correctList.add(task2)
//        correctList.add(task4)
//        correctList.add(task3)
//        correctList.add(task1)
//
//        val sortedTasks = sorter.sort(tasksToSort)
//        assertEquals(correctList, sortedTasks)
//    }
//
//    @Test
//    fun checkSortWhenOneFieldIsSetAtThird(){
//        val sorter = TaskSorter()
//        sorter.setThirdField(TaskSorter.PRIORITY)
//
//        val correctList = ArrayList<Task>()
//        correctList.add(task2)
//        correctList.add(task4)
//        correctList.add(task3)
//        correctList.add(task1)
//
//        val sortedTasks = sorter.sort(tasksToSort)
//        assertEquals(correctList, sortedTasks)
//    }
//
//    @Test
//    fun checkSortWhenTwoFieldsAreSetAtPrimaryAndSecondary(){
//        val sorter = TaskSorter()
//        sorter.setPrimaryField(TaskSorter.PRIORITY)
//        sorter.setSecondaryField(TaskSorter.DEADLINE)
//
//        val correctList = ArrayList<Task>()
//        correctList.add(task2)
//        correctList.add(task4)
//        correctList.add(task3)
//        correctList.add(task1)
//
//        val sortedTasks = sorter.sort(tasksToSort)
//        assertEquals(correctList, sortedTasks)
//    }
//
//    @Test
//    fun checkSortWhenTwoFieldsAreSetAtPrimaryAndThird(){
//        val sorter = TaskSorter()
//        sorter.setPrimaryField(TaskSorter.DEADLINE)
//        sorter.setThirdField(TaskSorter.PRIORITY)
//
//        val correctList = ArrayList<Task>()
//        correctList.add(task1)
//        correctList.add(task4)
//        correctList.add(task2)
//        correctList.add(task3)
//
//        val sortedTasks = sorter.sort(tasksToSort)
//        assertEquals(correctList, sortedTasks)
//    }
//
//    @Test
//    fun checkSortWhenTwoFieldsAreSetAtSecondaryAndThird(){
//        val sorter = TaskSorter()
//        sorter.setSecondaryField(TaskSorter.CREATION_DATE)
//        sorter.setThirdField(TaskSorter.PRIORITY)
//
//        val correctList = ArrayList<Task>()
//        correctList.add(task2)
//        correctList.add(task1)
//        correctList.add(task3)
//        correctList.add(task4)
//
//        val sortedTasks = sorter.sort(tasksToSort)
//        assertEquals(correctList, sortedTasks)
//    }
//
//    @Test
//    fun checkSortWhenThreeFieldsAreSet(){
//        val sorter = TaskSorter()
//        sorter.setPrimaryField(TaskSorter.DEADLINE)
//        sorter.setSecondaryField(TaskSorter.CREATION_DATE)
//        sorter.setThirdField(TaskSorter.PRIORITY)
//
//        val correctList = ArrayList<Task>()
//        correctList.add(task1)
//        correctList.add(task4)
//        correctList.add(task2)
//        correctList.add(task3)
//
//        val sortedTasks = sorter.sort(tasksToSort)
//        assertEquals(correctList, sortedTasks)
//    }
//
//    @Test
//    fun checkSortWhenThreeFieldsAreSetAtSamePosition(){
//        val sorter = TaskSorter()
//        sorter.setSecondaryField(TaskSorter.DEADLINE)
//        sorter.setSecondaryField(TaskSorter.CREATION_DATE)
//        sorter.setSecondaryField(TaskSorter.PRIORITY)
//
//        val correctList = ArrayList<Task>()
//        correctList.add(task2)
//        correctList.add(task3)
//        correctList.add(task4)
//        correctList.add(task1)
//
//        val sortedTasks = sorter.sort(tasksToSort)
//        assertEquals(correctList, sortedTasks)
//    }
//
//    @Test
//    fun checkSortWhenNoneOfFieldsIsSet(){
//        val sorter = TaskSorter()
//
//        val correctList = ArrayList<Task>()
//        correctList.add(task1)
//        correctList.add(task2)
//        correctList.add(task3)
//        correctList.add(task4)
//
//        val sortedTasks = sorter.sort(tasksToSort)
//        assertEquals(correctList, sortedTasks)
//    }
}